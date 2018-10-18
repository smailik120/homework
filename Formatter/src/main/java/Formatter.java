
import java.io.*;
import java.util.HashMap;

public class Formatter {
    public void addSpaces(int tab, FileOutputStream result) throws IOException {
        for (int i = 0; i < tab * 4; i++) {
            result.write(' ');
        }
    }

    public void format(FileInputStream source, FileOutputStream result) throws IOException {
        int tab = 0;
        int symbol;
        int previous = 0;
        while ((symbol = source.read()) != -1) {
            previous = symbol;
            switch (symbol) {
                case '{':
                    result.write(symbol);
                    tab++;
                    break;
                case ';':
                    result.write(symbol);
                    break;
                case '}':
                    tab--;
                    addSpaces(tab, result);
                    result.write(symbol);
                    break;
                case '\n':
                    result.write(symbol);
                    break;
                default:
                    if (previous == '\n') {
                        addSpaces(tab, result);
                        result.write(symbol);
                    } else {
                        result.write(symbol);
                    }
                    break;

            }
        }
    }
}

