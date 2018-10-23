package work.with.files;
import exception.ReaderException;
import formatter.core.IReader;
import java.io.IOException;

/**
 * String reader.
 */
public class ReaderOfString implements IReader<Character> {
    /**
     * pos.
     */
    private int pos = 0;
    /**
     * StringBuilder.
     */
    private StringBuilder input;

    /**
     *  start.
     * @param input StringBuilder.
     */
    public ReaderOfString(final StringBuilder input) {
        this.input = input;
    }

    /**
     * check that read must continue
     * @return boolean.
     * @throws ReaderException exception.
     */
    public final boolean hasChars() throws ReaderException {
        return input.length() > pos;
    }

    /**
     *  read symbol
     * @return char,
     * @throws ReaderException exception.
     */
    public final Character readLexeme() throws ReaderException {
        Character current;
        current = input.charAt(pos);
        pos++;
        return current;
    }

    /**
     *  .
     * @throws IOException exception.
     */
    public void close() throws IOException {

    }

}