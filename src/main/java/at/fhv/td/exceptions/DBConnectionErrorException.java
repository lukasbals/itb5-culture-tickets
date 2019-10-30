package at.fhv.td.exceptions;

/**
 * @author Lukas Bals
 */
public class DBConnectionErrorException extends Exception {
    private static final String TITLE = "DB connection error";
    private static final String MESSAGE = "Failed to connect to the database";

    public String getTitle() {
        return TITLE;
    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
