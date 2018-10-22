package LexicalAnalyzer;

import WorkWithFiles.WriterToFile;
import exception.WriterException;

public class Space extends Lexema implements Action {
    public Space(char symbol) {
        super(symbol);
    }

    public void action(WriterToFile writer) throws WriterException {
        String state = FormatterAnalyzer.getAnalyzer().getState();
        if(state.equals("symbol")) {
            writer.writeChar(' ');
            FormatterAnalyzer.getAnalyzer().setState("space");
        }
    }
}