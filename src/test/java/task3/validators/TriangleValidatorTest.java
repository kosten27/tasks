package task3.validators;

import exceptions.ValidationException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TriangleValidatorTest {
    private TriangleValidator triangleValidator;

    @Before
    public void setUp() throws Exception {
        triangleValidator = new TriangleValidator();
    }

    @Test(expected = ValidationException.class)
    public void validatePossibilityOfUnrealTriangleTest() throws ValidationException {
        //GIVEN
        double side1 = 5.0;
        double side2 = 3.0;
        double side3 = 1.0;

        //WHEN
        triangleValidator.validatePossibilityOfTriangle(side1, side2, side3);
    }

    @Test(expected = ValidationException.class)
    public void validatePossibilityOfTriangleNegativeSidesTest() throws ValidationException {
        //GIVEN
        double side1 = -5.0;
        double side2 = -3.0;
        double side3 = -1.0;

        //WHEN
        triangleValidator.validatePossibilityOfTriangle(side1, side2, side3);
    }

    @Test
    public void validatePossibilityOfRealTriangleTest() throws ValidationException {
        //GIVEN
        double side1 = 5.0;
        double side2 = 3.0;
        double side3 = 3.0;

        //WHEN
        triangleValidator.validatePossibilityOfTriangle(side1, side2, side3);
    }
}