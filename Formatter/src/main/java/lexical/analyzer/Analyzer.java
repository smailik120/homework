package lexical.analyzer;

import lexical.analyzer.lexema.Lexema;
import work.with.files.ReaderOfFile;
import work.with.files.ReaderOfString;
import work.with.files.WriterToFile;
import exception.ReaderException;
import exception.WriterException;
import work.with.files.WriterToString;

import java.io.IOException;
import java.util.HashMap;
/**
 * Class for description analyzer for specific task
 */
public abstract class Analyzer {
    private HashMap<Character, Lexema> map = new HashMap<Character, Lexema>();
    public HashMap<Character, Lexema> getMap() {
        return map;
    }
    /**
     * initialization for our analyzer
     */
    abstract void init();
    /**
     * function make work for our analyzer
     * @param reader ReaderOfFile.
     * @param writer WriterToFile.
     * @throws ReaderException exception.
     * @throws WriterException exception.
     * @throws IOException exception.
     */
    abstract void work(ReaderOfFile reader, WriterToFile writer) throws ReaderException, WriterException, IOException;
    /**
     * function make work for our analyzer
     * @param reader ReaderOfString.
     * @param writer WriterToString.
     * @throws ReaderException exception.
     * @throws WriterException exception.
     * @throws IOException exception.
     */
    abstract void work(ReaderOfString reader, WriterToString writer) throws ReaderException, WriterException, IOException;
}
