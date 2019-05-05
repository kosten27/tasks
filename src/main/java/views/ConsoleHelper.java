package views;

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
        return scanner.nextLine();
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
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
                isRunning = false;
            } else {
                scanner.next();
            }
        }
        return value;
    }

    public void close() {
        scanner.close();
    }
}
