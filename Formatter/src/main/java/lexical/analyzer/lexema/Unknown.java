package lexical.analyzer.lexema;

import formatter.core.IWriter;
import lexical.analyzer.FormatterAnalyzer;
import exception.WriterException;
/**
 * Class for description symbols that not contains in alphabetical
 */
public class Unknown extends Lexema implements Action {
    /**
     *
     * @param symbol char.
     */
    public Unknown(final char symbol) {
        super(symbol);
    }
    /**
     * @param writer WriterToFile.
     * @throws WriterException exception.
     */
    public void action(final IWriter writer) throws WriterException {
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
        if (FormatterAnalyzer.getAnalyzer().getState().equals("space")) {
            writer.writeChar(' ');
        }
        writer.writeChar(getSymbol());
        FormatterAnalyzer.getAnalyzer().setState("symbol");
    }
}