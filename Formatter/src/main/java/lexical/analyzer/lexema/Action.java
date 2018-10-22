package lexical.analyzer.lexema;

import formatter.core.IWriter;
import exception.WriterException;
/**
 * Interface for Action that can execute in lexem
 */
public interface Action {
    /**
     * @param writer WriterToFile.
     * @throws WriterException exception.
     */
    void action(IWriter writer) throws WriterException;
}
