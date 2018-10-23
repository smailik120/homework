package lexical.analyzer.lexema;

import formatter.core.IWriter;
import lexical.analyzer.FormatterAnalyzer;
import exception.WriterException;
/**
 * Class for description }
 */
public class CloseClosure extends Lexema implements Action {
    /**
     * constructor
     * @param symbol char.
     */
    public CloseClosure(final char symbol) {
        super(symbol);
    }
    /**
     * realization method action for } in interface Action make action leaning on previous symbol
     * @param writer WriterToFile.
     */
    public void action(final IWriter writer) {
        try {
            writer.writeChar('\r');
            writer.writeChar('\n');
            FormatterAnalyzer formatterAnalyzer = FormatterAnalyzer.getAnalyzer();
            FormatterAnalyzer.getAnalyzer().setSpaceCounter(formatterAnalyzer.getSpaceCounter() - formatterAnalyzer.getSpaces());
            for (int i = 1; i <= FormatterAnalyzer.getAnalyzer().getSpaceCounter(); i++) {
                writer.writeChar(' ');
            }
            writer.writeChar(getSymbol());
            FormatterAnalyzer.getAnalyzer().setState("close");
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
