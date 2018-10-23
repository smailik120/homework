package lexical.analyzer.lexema;

import formatter.core.IWriter;
import lexical.analyzer.FormatterAnalyzer;
import exception.WriterException;
/**
 * Class for description space
 */
public class Space extends Lexema implements Action {
    /**
     * constructor
     * @param symbol char.
     */
    public Space(final char symbol) {
        super(symbol);
    }
    /**
     * realization method action for ' ' in interface Action make action leaning on previous symbol
     * @param writer WriterToFile.
     * @throws WriterException exception.
     */
    public void action(final IWriter writer) throws WriterException {
        String state = FormatterAnalyzer.getAnalyzer().getState();
        if (state.equals("symbol")) {
            FormatterAnalyzer.getAnalyzer().setState("space");
        }
    }
}