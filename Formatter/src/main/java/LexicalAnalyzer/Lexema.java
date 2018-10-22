package LexicalAnalyzer;

import WorkWithFiles.WriterToFile;
import exception.WriterException;

import java.util.Objects;

public class Lexema implements Action{
    public Lexema(char symbol) {
        this.symbol = symbol;
    }

    private char symbol;

    public boolean equals(Lexema lexema) {
        return symbol == lexema.getSymbol();
    }

    public char getSymbol() {
        return symbol;
    }

    public void action(WriterToFile writer) throws WriterException {
    }
}
