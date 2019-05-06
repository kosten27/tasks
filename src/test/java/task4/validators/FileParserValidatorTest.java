package task4.validators;

import exceptions.ValidationException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileParserValidatorTest {
    private FileParserValidator fileParserValidator;

    @Before
    public void setUp() throws Exception {
        fileParserValidator = new FileParserValidator();
    }

    @Test(expected = ValidationException.class)
    public void validateWrongParametersForSearchTest() throws ValidationException {
        //GIVEN
        String[] args = {"path"};

        //WHEN
        fileParserValidator.validateParametersForSearch(args);
    }

    @Test
    public void validateCorrectParametersForSearchTest() throws ValidationException {
        //GIVEN
        String[] args = {"path", "string"};

        //WHEN
        fileParserValidator.validateParametersForSearch(args);
    }

    @Test(expected = ValidationException.class)
    public void validateWrongParametersForReplace() throws ValidationException {
        //GIVEN
        String[] args = {"path", "string1"};

        //WHEN
        fileParserValidator.validateParametersForReplace(args);
    }

    @Test
    public void validateCorrectParametersForReplace() throws ValidationException {
        //GIVEN
        String[] args = {"path", "string1", "string2"};

        //WHEN
        fileParserValidator.validateParametersForReplace(args);
    }
}