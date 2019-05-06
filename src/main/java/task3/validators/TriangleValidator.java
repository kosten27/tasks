package task3.validators;

import exceptions.ValidationException;

public class TriangleValidator {
    private final String MESSAGE_TRIANGLE_CAN_NOT_EXIST = "Triangle can't exist";

    public void validatePossibilityOfTriangle(double side1, double side2, double side3) throws ValidationException {
        double minWrongSide = 0.0;
        if (side1 <= minWrongSide || side2 <= minWrongSide || side3 <= minWrongSide) {
            throw new ValidationException(MESSAGE_TRIANGLE_CAN_NOT_EXIST);
        }
        double halfPerimeter = (side1 + side2 + side3) / 2;
        if (side1 >= halfPerimeter || side2 >= halfPerimeter || side3 >= halfPerimeter) {
            throw new ValidationException(MESSAGE_TRIANGLE_CAN_NOT_EXIST);
        }
    }
}
