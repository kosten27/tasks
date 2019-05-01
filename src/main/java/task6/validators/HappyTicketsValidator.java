package task6.validators;

import exceptions.ValidationException;

public class HappyTicketsValidator {
    private final String WRONG_FILE_CONTENTS_EXCEPTION = "In the file you must specify the counting algorithm: " +
            "'Moskow' or 'Piter'";

    public void validateFileContents(String fileContents) throws ValidationException {
        if (!"Moskow".equals(fileContents)
                && !"Piter".equals(fileContents)) {
            throw new ValidationException(WRONG_FILE_CONTENTS_EXCEPTION);
        }
    }
}
