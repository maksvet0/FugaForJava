package people.svet;

import people.svet.library.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;

public class App
{
    public static void main( String[] args ) throws NotSuitableFileException, IOException, UnexpectednessFieldExtension, NoMetadata, NotSuitableVersion {
        FugaFile ff = new FugaFile(Paths.get("C:\\d\\svet.fuga"));
        FugaHandler fh = new FugaHandler(ff);
        Random random = new Random();
//        fh.addField(new FugaField("svet", FugaTypes.BOOL, random.nextBoolean()));
        System.out.println(fh.isFieldExistsByName("svet"));
    }
}
