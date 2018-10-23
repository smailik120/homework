package work.with.files;
import exception.WriterException;
import formatter.core.IWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Class for description Writer to file, realize interface IWriter that write to file
 */
public class WriterToFile implements IWriter<Character> {
    private final BufferedWriter output;
    /**
     * constructor
     * @param output String.
     * @throws IOException exception.
     */
    public WriterToFile(final String output) throws IOException {
        this.output = new BufferedWriter(new FileWriter(output));
    }
    /**
     * write char to output stream
     * @param current Character.
     * @throws WriterException exception.
     */
    public void writeChar(final Character current) throws WriterException {
        try {
            output.write(current);
        } catch (IOException e) {
            throw new WriterException("error");
        }
    }
    /**
     * this method for close output stream
     */
    public void close() {
        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
