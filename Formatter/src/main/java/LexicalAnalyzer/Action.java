package LexicalAnalyzer;

import WorkWithFiles.WriterToFile;
import exception.WriterException;

public interface Action {
    void action(WriterToFile writer) throws WriterException;
}
