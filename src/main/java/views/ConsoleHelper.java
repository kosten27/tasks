package views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleHelper {
    private final Scanner scanner;

    public ConsoleHelper() {
        scanner = new Scanner(new InputStreamReader(System.in));
    }

    public void write(String s) {
        System.out.println(s);
    }

    public String read() {
        return scanner.next();
    }

    public String read(String s) {
        write(s);
        return read();
    }

    public double readDouble(String s) {
        boolean isRunning = true;
        double value = 0.0;
        while (isRunning) {
            write(s);
            if (scanner.hasNextDouble()) {
                value = scanner.nextDouble();
                isRunning = false;
            } else {
                scanner.next();
            }
        }
        return value;
    }
}
