package exception;

/**
 * Read Exception.
 */
public class ReaderException extends Exception {
    /**
     * constructor exception that can appear when you read
     * @param message string.
     */
    public ReaderException(final String message) {
        super(message);
    }
}