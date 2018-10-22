package LexicalAnalyzer;

import WorkWithFiles.WriterToFile;
import exception.WriterException;

public class OpenClosure extends Lexema implements Action {
    public OpenClosure(char symbol) {
        super(symbol);
    }

    public void action(WriterToFile writer) {
        try {
            if(FormatterAnalyzer.getAnalyzer().getState().equals("symbol")) {
                writer.writeChar(' ');
            }
            if (FormatterAnalyzer.getAnalyzer().getState().equals("space")) {
                writer.writeChar(getSymbol());
                FormatterAnalyzer.getAnalyzer().setSpaceCounter(FormatterAnalyzer.getAnalyzer().getSpaceCounter() + 4);
            }
            if (FormatterAnalyzer.getAnalyzer().getState().equals("open")) {
                writer.writeChar('\r');
                writer.writeChar('\n');
                for(int i = 1; i <= FormatterAnalyzer.getAnalyzer().getSpaceCounter(); i++) {
                    writer.writeChar(' ');
                }
                FormatterAnalyzer.getAnalyzer().setSpaceCounter(FormatterAnalyzer.getAnalyzer().getSpaceCounter() + 4);
                writer.writeChar(getSymbol());
            }
            FormatterAnalyzer.getAnalyzer().setState("open");
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
