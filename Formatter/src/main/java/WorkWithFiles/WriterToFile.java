package WorkWithFiles;

import exception.WriterException;
import formatter.core.IWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToFile implements IWriter<Character> {
    private final BufferedWriter output;

    public WriterToFile(String output) throws IOException {
        this.output = new BufferedWriter(new FileWriter(output));
    }

    public void writeChar(Character current) throws WriterException {
        try {
            output.write(current);
        } catch (IOException e) {
            throw new WriterException("error");
        }
    }

    public void close() {
        try {
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
