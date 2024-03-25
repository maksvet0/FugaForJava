package people.svet.library;

public enum FugaTypes {
    INTEGER(Integer.class),
    BOOL(Boolean.class),
    VERSION(FugaVersion.class),
    STRING(String.class),
    FLOAT(Float.class),
    STRUCT(FugaStruct.class);

    private final Class<?> AssocType;
    public Class<?> getAssocType(){
        return AssocType;
    }
    FugaTypes(Class<?> assocType) {
        AssocType = assocType;
    }
}
