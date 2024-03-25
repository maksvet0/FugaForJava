package people.svet.library;

public class FugaField {
    public String Name;
    public FugaTypes Type;
    public Object Value;

    public FugaField(String name, FugaTypes type, Object value) {
        Name = name;
        Type = type;
        Value = value;
    }

    public FugaField(String fromThere) throws UnexpectednessFieldExtension {
        StringBuilder id = new StringBuilder();
        String[] temp = fromThere.split("=", 2);
        for (int i = temp[0].indexOf("<") + 1; i <= temp[0].length() - 1; i++){
            id.append(temp[0].charAt(i));
        }
        id = new StringBuilder(id.substring(0, id.length() - 1));
        Name = temp[0].substring(0, temp[0].length() - id.length() - 2);

        switch (id.toString()){
            case "int":
                Type = FugaTypes.INTEGER;
                Value = Integer.valueOf(temp[1].replace("\t", ""));
                break;
            case "str":
                Type = FugaTypes.STRING;
                Value = String.valueOf(temp[1]);
                break;
            case "ver":
                Type = FugaTypes.VERSION;
                String[] temp2 = temp[1].split("\\.");
                Value = new FugaVersion(Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1]), Integer.parseInt(temp2[2]));
                break;
            case "bool":
                Value = Boolean.valueOf(temp[1]);
                Type = FugaTypes.BOOL;
                break;
            case "float":
                Value = Float.valueOf(temp[1]);
                Type = FugaTypes.FLOAT;
                break;
            case "struct":
                String s = temp[1].substring(1);
                s = s.substring(0, s.length() - 1);
                Value = new FugaStruct(s);
                Type = FugaTypes.STRUCT;
                break;
            default:
                System.out.println(id);
                throw new UnexpectednessFieldExtension();
        }
    }
    public static String fieldToString(FugaField field) throws UnexpectednessFieldExtension {
        String s;
        switch (field.Type){
            case INTEGER:
                s = "int";
                break;
            case BOOL:
                s = "bool";
                break;
            case VERSION:
                s = "ver";
                break;
            case STRING:
                s = "str";
                break;
            case FLOAT:
                s = "float";
                break;
            default:
                throw new UnexpectednessFieldExtension();
        }
        return String.format("%s<%s>=%s", field.Name, s, field.Value);
    }
}
