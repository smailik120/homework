package sevenbits.homework;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 2) {
            FileInputStream fileIn = new FileInputStream(args[0]);
            FileOutputStream fileOut = new FileOutputStream(args[1]);
            Formatter formatter = new Formatter();
            formatter.format(fileIn, fileOut);
            fileIn.close();
            fileOut.close();
        }
        else {
            System.out.println("please enter input and output file in console or edit run configuration");
        }
    }
}