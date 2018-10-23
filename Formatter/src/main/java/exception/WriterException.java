package exception;
/**
 * Write Exception.
 */
public class WriterException extends Exception {
    /**
     * constructor exception that can appear when you write
     * @param message string.
     */
    public WriterException(final String message) {
        super(message);
    }
}
