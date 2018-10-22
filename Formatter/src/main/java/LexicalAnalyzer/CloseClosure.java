package LexicalAnalyzer;

import WorkWithFiles.WriterToFile;
import exception.WriterException;

import java.awt.event.ActionListener;

public class CloseClosure extends Lexema implements Action {
    public CloseClosure(char symbol) {
        super(symbol);
    }

    public void action(WriterToFile writer) {
        try {
            writer.writeChar('\r');
            writer.writeChar('\n');
            FormatterAnalyzer.getAnalyzer().setSpaceCounter(FormatterAnalyzer.getAnalyzer().getSpaceCounter() - 4);
            for(int i = 1; i <= FormatterAnalyzer.getAnalyzer().getSpaceCounter(); i++) {
                writer.writeChar(' ');
            }
            writer.writeChar(getSymbol());
            FormatterAnalyzer.getAnalyzer().setState("close");
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
