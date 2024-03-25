package people.svet.library;

public class NotSuitableFileException extends Exception {
    private String Why;

    public NotSuitableFileException(String why) {
        Why = why;
    }
    public NotSuitableFileException() {
        Why = "File damaged or have not supporting extension";
    }

    public String getWhy() {
        return Why;
    }
}
