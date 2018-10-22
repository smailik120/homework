package lexical.analyzer.lexema;

import formatter.core.IWriter;
import lexical.analyzer.FormatterAnalyzer;
import exception.WriterException;
/**
 * Class for description ;
 */
public class Semicolon extends Lexema implements Action {
    /**
     *
     * @param symbol char.
     */
    public Semicolon(final char symbol) {
        super(symbol);
    }
    /**
     * @param writer WriterToFile.
     * @throws WriterException exception.
     */
    public void action(final IWriter writer) throws WriterException {
        if (FormatterAnalyzer.getAnalyzer().getState() == "symbol") {
            writer.writeChar(';');
            FormatterAnalyzer.getAnalyzer().setState("semicolon");
        }
    }
}
