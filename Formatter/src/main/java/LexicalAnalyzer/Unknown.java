package LexicalAnalyzer;

import WorkWithFiles.WriterToFile;
import exception.WriterException;

public class Unknown extends Lexema implements Action {
    public Unknown(char symbol) {
        super(symbol);
    }

    public void action(WriterToFile writer) throws WriterException {
        if (FormatterAnalyzer.getAnalyzer().getState().equals("semicolon")) {
            writer.writeChar('\r');
            writer.writeChar('\n');
            for (int i = 1; i <= FormatterAnalyzer.getAnalyzer().getSpaceCounter(); i++) {
                writer.writeChar(' ');
            }
        }
        if (FormatterAnalyzer.getAnalyzer().getState().equals("close")) {
            writer.writeChar(' ');
        }
        if (FormatterAnalyzer.getAnalyzer().getState().equals("open")) {
            writer.writeChar('\r');
            writer.writeChar('\n');
            for (int i = 1; i <= FormatterAnalyzer.getAnalyzer().getSpaceCounter(); i++) {
                writer.writeChar(' ');
            }
        }
        writer.writeChar(getSymbol());
        FormatterAnalyzer.getAnalyzer().setState("symbol");
    }
}