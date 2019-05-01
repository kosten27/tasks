package util;

import java.io.IOException;

public class StringParser {
    public static int getNumberOfSubstring(String string, String substring) throws IOException {
        return string.split(substring).length - 1;
    }
}
