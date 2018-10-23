package lexical.analyzer;
import lexical.analyzer.lexema.Carrage;
import lexical.analyzer.lexema.CloseClosure;
import lexical.analyzer.lexema.OpenClosure;
import lexical.analyzer.lexema.Space;
import lexical.analyzer.lexema.Semicolon;
import lexical.analyzer.lexema.Unknown;
import work.with.files.ReaderOfFile;
import work.with.files.ReaderOfString;
import work.with.files.WriterToFile;
import exception.ReaderException;
import exception.WriterException;
import work.with.files.WriterToString;

import java.io.IOException;
/**
 * Class for description ForamtterAnalyzer make fomat code in input and give result to output
 */
public final class FormatterAnalyzer extends Analyzer {
    private int spaceCounter;
    private String state;
    private static FormatterAnalyzer analyzer = new FormatterAnalyzer();
    private final int spaces = 4;
    private FormatterAnalyzer() {
        super();
        setState("space");
        init();
    }
    /**
     * initialization for formatter analyzer
     */
    public void init() {
        getMap().put('{', new OpenClosure('{'));
        getMap().put('}', new CloseClosure('}'));
        getMap().put(' ', new Space(' '));
        getMap().put('\n', new Carrage('\n'));
        getMap().put('\r', new Carrage('\r'));
        getMap().put(';', new Semicolon(';'));
    }
    /**
     * function make work for formatter analyzer with files
     * @param reader ReaderOfFile.
     * @param writer wruterToFile.
     * @throws ReaderException exception.
     * @throws WriterException exception.
     * @throws IOException exception.
     */
    public void work(final ReaderOfFile reader, final WriterToFile writer) throws ReaderException, WriterException, IOException {
        reader.readLexeme();
        while (reader.hasChars()) {
            System.out.println(FormatterAnalyzer.getAnalyzer().getState());
            char current = reader.readLexeme();
            if (getMap().containsKey(current)) {
                getMap().get(current).action(writer);
            } else {
                getMap().put(current, new Unknown(current));
                getMap().get(current).action(writer);
            }
        }
        reader.close();
        writer.close();
    }
    /**
     * function make work for formatter analyzer with strings
     * @param reader ReaderOfString.
     * @param writer WriterToString.
     * @throws ReaderException exception.
     * @throws WriterException exception.
     * @throws IOException exception.
     */
    public void work(final ReaderOfString reader, final WriterToString writer) throws ReaderException, WriterException, IOException {
        while (reader.hasChars()) {
            Character current = reader.readLexeme();
            if (getMap().containsKey(current)) {
                getMap().get(current).action(writer);
            } else {
                getMap().put(current, new Unknown(current));
                getMap().get(current).action(writer);
            }
        }
        reader.close();
        writer.close();
    }
    public int getSpaces() {
        return spaces;
    }
    public void setSpaceCounter(final int spaceCounter) {
        this.spaceCounter = spaceCounter;
    }

    public int getSpaceCounter() {
        return spaceCounter;
    }

    public static FormatterAnalyzer getAnalyzer() {
        return analyzer;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
