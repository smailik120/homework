import LexicalAnalyzer.*;
import WorkWithFiles.ReaderOfFile;
import WorkWithFiles.WriterToFile;
import exception.ReaderException;
import exception.WriterException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(final String[] args) throws IOException, ReaderException, WriterException {
        ReaderOfFile reader = new ReaderOfFile(args[0]);
        WriterToFile writer = new WriterToFile(args[1]);
        FormatterAnalyzer analyzer = FormatterAnalyzer.getAnalyzer();
        analyzer.work(reader, writer);
    }
}
