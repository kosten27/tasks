package task4.services;

import org.junit.Before;
import org.junit.Test;
import services.FileWorkerService;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class FileParserServiceTest {
    private FileWorkerService fileWorkerService;
    private FileParserService fileParserService;

    @Before
    public void setUp() throws Exception {
        fileWorkerService = mock(FileWorkerService.class);
        String fileContext = "Oracle Corporation is an American multinational computer technology corporation " +
                "headquartered in Redwood Shores, California. The company sells database software and technology, " +
                "cloud engineered systems, and enterprise software products—particularly its own brands of database " +
                "management systems. In 2018, Oracle was the third-largest software company by revenue.";
        when(fileWorkerService.getFileContents(anyString())).thenReturn(fileContext);

        fileParserService = new FileParserService(fileWorkerService);
    }

    @Test
    public void getNumberOfLineEntriesInTextFileTest() throws IOException {
        //GIVEN
        int expectedNumberOfLine = 3;
        String searchString = "software";

        //WHEN
        int numberOfLine = fileParserService.getNumberOfLineEntriesInTextFile("", searchString);

        //THEN
        assertEquals(expectedNumberOfLine, numberOfLine);
    }

    @Test
    public void replaceLineInFileTest() throws IOException {
        //GIVEN
        String filePath = "";
        String searchString = "software";
        String replacementString = "hardware";
        doNothing().when(fileWorkerService).putFileContents(eq(filePath), anyString());

        //WHEN
        fileParserService.replaceLineInFile(filePath, searchString, replacementString);

        //THEN
        verify(fileWorkerService, times(1)).putFileContents(eq(filePath), anyString());
    }
}