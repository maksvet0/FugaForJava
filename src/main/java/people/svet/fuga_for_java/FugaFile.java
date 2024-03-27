package people.svet.fuga_for_java;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class FugaFile {
    private final File file;
    private final String Lines;
    private final FugaVersion Version;
    public FugaFile(Path pathToFile) throws NotSuitableFileException, IOException, NoMetadata, UnexpectednessFieldExtension, NotSuitableVersion {
        if(!(Files.isReadable(pathToFile) && getFileExtensionUsingPath(pathToFile.toString()).equalsIgnoreCase( "fuga"))) throw new NotSuitableFileException();
        file = new File(pathToFile.toUri());
        BufferedReader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
        StringBuilder multiline = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            multiline.append(line);
        }
        reader.close();
        Lines = multiline.toString();
        String[] t =  multiline.toString().split(";");
        if(t[0].charAt(0) != '!') throw new NoMetadata();
        FugaField version = new FugaField(t[0].substring(1));
        if(!(ListOfSupportingVersions.Equals(((FugaVersion) version.Value)))) throw new NotSuitableVersion();
        Version = (FugaVersion) version.Value;
    }
    private static String getFileExtensionUsingPath(String filePath) {
        Path path = Paths.get(filePath);
        String fileName = path.getFileName().toString();
        String fileExtension = "";

        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex > 0) {
            fileExtension = fileName.substring(lastIndex + 1);
        }
        return fileExtension;
    }

    public String getLines() {
        return Lines;
    }
    public File getFile(){return file;}
    public FugaVersion getVersion() {
        return Version;
    }
}
