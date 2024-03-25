package people.svet.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FugaStruct {
    List<FugaField> ListOfFields = new ArrayList<FugaField>();

    public FugaStruct(String fromThere) throws UnexpectednessFieldExtension {
        String[] s = fromThere.split(",");
        for(String se : s){
            ListOfFields.add(new FugaField(se));
        }
    }
    public Object GetValueByName(String name) throws FieldNameNotFound {
        Object i = null;
        for (FugaField f : ListOfFields){
            if(Objects.equals(f.Name, name)) i = f.Value;
        }
        if(i == null) throw new FieldNameNotFound();
        return i;
    }
}
