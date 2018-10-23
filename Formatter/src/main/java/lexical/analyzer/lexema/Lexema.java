package lexical.analyzer.lexema;
import formatter.core.IWriter;
import exception.WriterException;
/**
 * Class for description words of our language
 */
public class Lexema implements Action {
    private char symbol;
    /**
     * constructor
     * @param symbol char.
     */
    public Lexema(final char symbol) {
        this.symbol = symbol;
    }
    public char getSymbol() {
        return symbol;
    }
    /**
     * get view this lexem
     * @param writer WriterToFile.
     * @throws WriterException exception.
     */
    public void action(final IWriter writer) throws WriterException {
    }
}
