package work.with.files;
import formatter.core.IWriter;
/**
 * String writer.
 */
public class WriterToString implements IWriter<Character> {
    /**
     * c.
     */
    private StringBuilder output;

    /**
     *
     * @return string.
     */
    public final String toString() {
        return output.toString();
    }

    /**
     * @param output StringBuilder
     */
    public WriterToString(final StringBuilder output) {
        this.output = output;
    }

    /**
     *
     * @param character string.
     */
    public final void writeChar(final Character character) {
        output.append(character);
    }

//    /**
//     * start.
//     * @param s char.
//     * @throws WriterException exception.
//     */
//    public final void writeChar(final char s) throws WriterException {
//        c.append(s);
//    }

    /**
     * this method for close output
     */
    public final void close() {
    }
}
