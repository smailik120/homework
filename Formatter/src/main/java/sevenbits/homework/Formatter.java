package sevenbits.homework;

import java.io.*;
import java.util.HashMap;

public class Formatter {
    public void addSpaces(int spaceCounter, FileOutputStream result) throws IOException {
        for (int i = 0; i < spaceCounter; i++) {
            result.write(' ');
        }
    }

    public void format(FileInputStream source, FileOutputStream result) throws IOException {
        int spaceCounter = 0;
        int symbol;
        int previous = 0;
        int tempSpaceCounter = 0;
        int proveDown = 1;
        while ((symbol = source.read()) != -1) {
            switch (symbol) {
                case '{':
                    result.write(symbol);
                    spaceCounter += 4;
                    break;
                case ';':
                    result.write(symbol);
                    result.write('\r');
                    result.write('\n');
                    tempSpaceCounter = 0;
                    previous = symbol;
                    proveDown = 0;
                    break;
                case '}':
                    spaceCounter -= 4;
                    addSpaces(spaceCounter-tempSpaceCounter, result);
                    result.write(symbol);
                    proveDown = 1;
                    break;
                case '\n':
                    result.write(symbol);
                    tempSpaceCounter = 0;
                    previous = symbol;
                    proveDown = 0;
                    break;
                case ' ':
                    result.write(symbol);
                    tempSpaceCounter++;
                    if(proveDown == 0) {
                        previous = symbol;
                    }
                    break;
                default:
                    if ((previous == '\n' || previous == ' ' || previous == ';') && proveDown == 0) {
                        addSpaces(spaceCounter - tempSpaceCounter, result);
                        result.write(symbol);
                        tempSpaceCounter = 0;
                        proveDown = 1;
                    } else {
                        result.write(symbol);
                        proveDown = 1;
                    }
                    break;

            }
        }
    }
}

