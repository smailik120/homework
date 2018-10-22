package lexical.analyzer.lexema;
import formatter.core.IWriter;
import exception.WriterException;
/**
 * Class for description words of our language
 */
public class Lexema implements Action {
    /**
     * @param symbol char.
     */
    public Lexema(final char symbol) {
        this.symbol = symbol;
    }

    private char symbol;
    /**
     * @param lexema Lexema.
     * @return boolean.
     */
    public boolean equals(final Lexema lexema) {
        return symbol == lexema.getSymbol();
    }

    public char getSymbol() {
        return symbol;
    }
    /**
     * @param writer WriterToFile.
     * @throws WriterException exception.
     */
    public void action(final IWriter writer) throws WriterException {
    }
}
