package people.svet.fuga_for_java;

public class FugaVersion {
    public final int FirstNum;
    public final int SecondNum;
    public final int ThirdNum;

    public FugaVersion(int firstNum, int secondNum, int thirdNum) {
        FirstNum = firstNum;
        SecondNum = secondNum;
        ThirdNum = thirdNum;
    }

    @Override
    public String toString() {
        return String.format("%d.%d.%d", FirstNum, SecondNum, ThirdNum);
    }
}
