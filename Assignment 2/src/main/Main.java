package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


public class Main {
    static PrintStream out;

    static {
        try {
            out = new PrintStream(new FileOutputStream("output.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws IOException {
        Performance.main();
        out.close();

    }

    public static void writeTo(String output) throws IOException {
        out.println(output);
    }




}