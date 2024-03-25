package people.svet.library;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FugaHandler {
//    private String Metadata = "!version<ver>=0.0.3;";
    private String lines;
    private List<String> split;
    private final FugaFile file;
    private final List<Integer> fieldsIndexes = new ArrayList<>();
    private final List<FugaField> fields = new ArrayList<>();
    public FugaHandler(FugaFile file) throws UnexpectednessFieldExtension {
        this.file = file;
        lines = file.getLines();
        split =  new ArrayList<String>(Arrays.asList(lines.split(";")));
        int i = 0;
        for (String t : split){
            i++;
            switch (t.charAt(0)){
                case '!':
                case '#':
                    continue;
                default:
                    fieldsIndexes.add(i);
                    fields.add(new FugaField(t));
                    break;
            }
        }
    }
    public Object getValueByName(String name) throws FieldNameNotFound {
        Object temp = null;
        for(FugaField field : fields){
            if(field.Name.equals(name)){
                temp = field.Value;
            }
        }
        if(temp == null) throw new FieldNameNotFound();
        return temp;
    }
    public void setValueByName(String name, Object newValue) throws IOException, UnexpectednessFieldExtension {
        BufferedWriter writer = Files.newBufferedWriter(file.getFile().toPath(), StandardCharsets.UTF_8);
        for(FugaField field : fields){
            if(field.Name.equals(name)){
                field.Value = newValue;
            }
        }
        for (int i = 0; i < fieldsIndexes.size(); i++) {
            split.set(fieldsIndexes.get(i) - 1, FugaField.fieldToString(fields.get(i)));
        }
        StringBuilder s = new StringBuilder();
        for (String string : split) {
            s.append(string).append(";\n");
        }
        lines = s.toString();
        split = Arrays.asList(lines.split(";"));
        writer.write(lines);
        writer.close();
    }
    public void addField(FugaField value) throws IOException, UnexpectednessFieldExtension {
        BufferedWriter writer = Files.newBufferedWriter(file.getFile().toPath(), StandardCharsets.UTF_8);
        fields.add(value);
        fieldsIndexes.add(fields.size()); // Add index based on the size of fields list
        int i = 0;
        split.add(FugaField.fieldToString(fields.get(i)));
//      file.getVersion().toString() + ";\n"
        StringBuilder s = new StringBuilder();
        for (String string : split) {
            s.append(string).append(";\n");
        }
        lines = s.toString();
        split = Arrays.asList(lines.split(";"));
        writer.write(lines);
        writer.close();
    }
    public boolean isFieldExistsByName(String name){
        Object temp = null;
        for(FugaField field : fields){
            if(Objects.equals(field.Name, name)) temp = field.Value;
        }
        if(temp == null) return false;
        return true;
    }
}
