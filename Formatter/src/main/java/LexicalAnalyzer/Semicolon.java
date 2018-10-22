package LexicalAnalyzer;

import WorkWithFiles.WriterToFile;
import exception.WriterException;

public class Semicolon extends Lexema implements Action {
    public Semicolon(char symbol) {
        super(symbol);
    }

    public void action(WriterToFile writer) throws WriterException {
        if(FormatterAnalyzer.getAnalyzer().getState() == "symbol") {
            writer.writeChar(';');
            FormatterAnalyzer.getAnalyzer().setState("semicolon");
        }
    }
}
