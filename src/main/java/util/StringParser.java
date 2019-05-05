package util;

public class StringParser {
    public static int getNumberOfSubstring(String string, String substring) {
        return string.split(substring).length - 1;
    }
}
