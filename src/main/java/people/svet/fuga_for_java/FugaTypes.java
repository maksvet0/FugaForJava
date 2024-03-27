package people.svet.fuga_for_java;

import java.util.List;

public enum FugaTypes {
    INTEGER(Integer.class),
    BOOL(Boolean.class),
    VERSION(FugaVersion.class),
    STRING(String.class),
    FLOAT(Float.class),
    STRUCT(FugaStruct.class),
    ARRAY(List.class);

    private final Class<?> AssocType;
    public Class<?> getAssocType(){
        return AssocType;
    }
    FugaTypes(Class<?> assocType) {
        AssocType = assocType;
    }
}
