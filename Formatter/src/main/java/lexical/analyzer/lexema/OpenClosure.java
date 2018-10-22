package lexical.analyzer.lexema;

import formatter.core.IWriter;
import lexical.analyzer.FormatterAnalyzer;
import exception.WriterException;
/**
 * Class for description {
 */
public class OpenClosure extends Lexema implements Action {
    /**
     *
     * @param symbol char.
     */
    public OpenClosure(final char symbol) {
        super(symbol);
    }
    /**
     *
     * @param writer WriterToFile.
     */
    public void action(final IWriter writer) {
        try {
            FormatterAnalyzer formatterAnalyzer = FormatterAnalyzer.getAnalyzer();
            if (formatterAnalyzer.getState().equals("symbol")) {
                writer.writeChar(' ');
            }
            if(FormatterAnalyzer.getAnalyzer().getState().equals("space")) {
                writer.writeChar(getSymbol());
                formatterAnalyzer.setSpaceCounter(formatterAnalyzer.getSpaceCounter() + formatterAnalyzer.getSpaces());
            }
            if (FormatterAnalyzer.getAnalyzer().getState().equals("open")) {
                writer.writeChar('\r');
                writer.writeChar('\n');
                for (int i = 1; i <= FormatterAnalyzer.getAnalyzer().getSpaceCounter(); i++) {
                    writer.writeChar(' ');
                }
                formatterAnalyzer.setSpaceCounter(formatterAnalyzer.getSpaceCounter() + formatterAnalyzer.getSpaces());
                writer.writeChar(getSymbol());
            }
            FormatterAnalyzer.getAnalyzer().setState("open");
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
