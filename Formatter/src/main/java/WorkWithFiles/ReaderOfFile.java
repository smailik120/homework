package WorkWithFiles;

import exception.ReaderException;
import formatter.core.IReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderOfFile implements IReader<Character> {
    private final BufferedReader input;
    /**
     *
     * @param input filename.
     * @throws FileNotFoundException exception.
     */
    public ReaderOfFile(final String input) throws FileNotFoundException {
        this.input = new BufferedReader(new FileReader(input));
    }
    /**
     *
     * @return char.
     * @throws ReaderException exception.
     */
    public Character readLexeme() throws ReaderException {
        int current;
        try {
            current = this.input.read();
        } catch (IOException e) {
            throw new ReaderException("error.");
        }
        return (char) current;
    }
    /**
     *
     * @throws IOException exception.
     */
    public void close() throws IOException {
        this.input.close();
    }
        /**
         *
         * @return boolean.
         * @throws ReaderException exception.
         */
        public final boolean hasChars() throws ReaderException {
            try {
                input.mark(1);
                int current = input.read();
                input.reset();
                return current != -1;
            } catch (IOException e) {
                throw new ReaderException("error.");
            }
        }
}
