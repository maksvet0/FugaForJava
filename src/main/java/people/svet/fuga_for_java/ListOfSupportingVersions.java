package people.svet.fuga_for_java;

public class ListOfSupportingVersions {
    public static final FugaVersion[] Versions = {
            new FugaVersion(0, 0, 0),
            new FugaVersion(0, 0, 1),
            new FugaVersion(0, 0, 2),
            new FugaVersion(0, 0, 3)
    };

    public static boolean Equals(FugaVersion obj) {
        boolean oo = false;
        for (FugaVersion ver : Versions){
            if(ver.FirstNum == obj.FirstNum && ver.SecondNum == obj.SecondNum && ver.ThirdNum == obj.ThirdNum) oo = true;
        }
        return oo;
    }
}
