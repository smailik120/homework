package lexical.analyzer.lexema;
import formatter.core.IWriter;
import lexical.analyzer.FormatterAnalyzer;
/**
 * Class for description move carrage on new string
 */
public class Carrage extends Lexema implements Action {
    /**
     * @param symbol char.
     */
    public Carrage(final char symbol) {
        super(symbol);
    }
    /**
     * @param writer WriterToFile.
     */
    public void action(final IWriter writer) {
        if (FormatterAnalyzer.getAnalyzer().getState().equals("semicolon")) {
            FormatterAnalyzer.getAnalyzer().setState("semicolon");
        } else if (FormatterAnalyzer.getAnalyzer().getState().equals("close")) {
            FormatterAnalyzer.getAnalyzer().setState("close");
        } else if (FormatterAnalyzer.getAnalyzer().getState().equals("open")) {
            FormatterAnalyzer.getAnalyzer().setState("open");
        } else {
            FormatterAnalyzer.getAnalyzer().setState("carrage");
        }
    }
}