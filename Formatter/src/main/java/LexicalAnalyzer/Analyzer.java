package LexicalAnalyzer;

import WorkWithFiles.ReaderOfFile;
import WorkWithFiles.WriterToFile;
import exception.ReaderException;
import exception.WriterException;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public abstract class Analyzer {
    private HashMap<Character, Lexema> map = new HashMap<Character, Lexema>();
    public HashMap<Character, Lexema> getMap() {
        return map;
    }
    abstract void init();
    abstract void work(ReaderOfFile reader, WriterToFile writer) throws ReaderException, WriterException, IOException;
}
