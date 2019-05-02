package task3.validators;

import exceptions.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TriangleValidator {
    private final String MESSAGE_FORMAT_OF_PARAMETERS = "Wrong format of parameters!";
    private final String MESSAGE_TRIANGLE_CAN_NOT_EXIST = "Triangle can't exist";

    public void validateFormatOfParameters(String value) throws ValidationException {
        Pattern pattern = Pattern.compile("^([^,])+,[\\s\\t\\d]+(\\.[\\s\\t\\d]+)?,[\\s\\t\\d]+(\\.[\\s\\t\\d]+)?," +
                "[\\s\\t\\d]+(\\.[\\s\\t\\d]+)?$");
        Matcher matcher = pattern.matcher(value);
        if (!matcher.find()) {
            throw new ValidationException(MESSAGE_FORMAT_OF_PARAMETERS);
        }
    }

    public void validatePossibilityOfTriangle(double side1, double side2, double side3) throws ValidationException {
        double p = (side1 + side2 + side3) / 2;
        if (side1 > p || side2 > p || side3 > p) {
            throw new ValidationException(MESSAGE_TRIANGLE_CAN_NOT_EXIST);
        }
    }
}
