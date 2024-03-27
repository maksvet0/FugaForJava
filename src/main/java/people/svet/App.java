package people.svet;

import people.svet.fuga_for_java.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws NotSuitableFileException, IOException, UnexpectednessFieldExtension, NoMetadata, NotSuitableVersion, FieldNameNotFound {
        FugaFile ff = new FugaFile(Paths.get("C:\\d\\svet.fuga"));
        FugaHandler fh = new FugaHandler(ff);
        List<String> l = (List<String>) fh.getValueByName("svet");
        for(String li : l){
            System.out.println(li);
        }
    }
}
