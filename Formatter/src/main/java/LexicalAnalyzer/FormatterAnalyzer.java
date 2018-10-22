package LexicalAnalyzer;

import WorkWithFiles.ReaderOfFile;
import WorkWithFiles.WriterToFile;
import exception.ReaderException;
import exception.WriterException;

import java.io.IOException;

public class FormatterAnalyzer extends Analyzer{
    private int spaceCounter;
    private String state;
    private static FormatterAnalyzer analyzer = new FormatterAnalyzer();
    private FormatterAnalyzer() {
        super();
        setState("space");
        init();
    }

    public void init() {
        getMap().put('{', new OpenClosure('{'));
        getMap().put('}', new CloseClosure('}'));
        getMap().put(' ', new Space(' '));
        getMap().put('\n', new Carrage('\n'));
        getMap().put('\r', new Carrage('\r'));
        getMap().put(';', new Semicolon(';'));
    }

    public void work(ReaderOfFile reader, WriterToFile writer) throws ReaderException, WriterException, IOException {
        reader.readLexeme();//символ начала файла
        while (reader.hasChars()) {
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
    public void setSpaceCounter(int spaceCounter) {
        this.spaceCounter = spaceCounter;
    }

    public int getSpaceCounter() {
        return spaceCounter;
    }

    public static FormatterAnalyzer getAnalyzer() {
        return analyzer;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
}
