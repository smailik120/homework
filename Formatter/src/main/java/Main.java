import lexical.analyzer.FormatterAnalyzer;
import work.with.files.ReaderOfFile;
import work.with.files.WriterToFile;
import exception.ReaderException;
import exception.WriterException;
import java.io.IOException;
/**
 * Class for begin execute programm
 */
public final class Main {
    private Main() {

    }
    /**
     * main function
     * @param args String[].
     * @throws IOException exception.
     * @throws ReaderException exception.
     * @throws WriterException exception.
     */
    public static void main(final String[] args) throws IOException, ReaderException, WriterException {
        ReaderOfFile reader = new ReaderOfFile(args[0]);
        WriterToFile writer = new WriterToFile(args[1]);
        FormatterAnalyzer analyzer = FormatterAnalyzer.getAnalyzer();
        analyzer.work(reader, writer);
    }
}
