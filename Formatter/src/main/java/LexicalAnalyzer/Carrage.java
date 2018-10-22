package LexicalAnalyzer;

import WorkWithFiles.WriterToFile;
public class Carrage extends Lexema implements Action {
    public Carrage(char symbol) {
        super(symbol);
    }

    public void action(WriterToFile writer) {
        System.out.println(FormatterAnalyzer.getAnalyzer().getState());
        if (FormatterAnalyzer.getAnalyzer().getState().equals("semicolon")) {
            FormatterAnalyzer.getAnalyzer().setState("semicolon");
        }
        else if (FormatterAnalyzer.getAnalyzer().getState().equals("close")) {
            FormatterAnalyzer.getAnalyzer().setState("close");
        }
        else if (FormatterAnalyzer.getAnalyzer().getState().equals("open")) {
            FormatterAnalyzer.getAnalyzer().setState("open");
        }
        else {
            FormatterAnalyzer.getAnalyzer().setState("carrage");
        }
    }
}