import application.Controller;
import services.FileWorkerService;
import task1.controllers.ChessBoardController;
import task1.services.ChessBoardService;
import task1.validators.ChessBoardValidator;
import task2.controllers.EnvelopeController;
import task2.services.EnvelopeService;
import task2.validators.EnvelopeValidator;
import task3.controllers.TriangleController;
import task3.services.TriangleService;
import task3.validators.TriangleValidator;
import task4.controllers.FileParserController;
import task4.services.FileParserService;
import task4.validators.FileParserValidator;
import task5.controllers.NumberInWordsController;
import task5.models.NumberInWordsRu;
import task5.services.NumberInWordsService;
import task5.validators.NumberInWordsValidator;
import task6.controllers.HappyTicketsController;
import task6.services.HappyTicketsServices;
import task6.validators.HappyTicketsValidator;
import task7.controllers.NumericSequenceController;
import task7.services.NumericSequenceServices;
import task7.validators.NumericSequenceValidator;
import task8.controllers.FibonacciNumbersController;
import task8.services.FibonacciNumbersService;
import task8.validators.FibonacciNumbersValidator;
import task9.controllers.ExponentiationControllers;
import task9.services.ExponentiationService;
import task9.validators.ExponentiationValidator;
import application.ConsoleHelper;
import application.TaskMenu;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        TaskMenu taskMenu = new TaskMenu(consoleHelper, getTasks(consoleHelper));
        taskMenu.run();
        consoleHelper.close();
    }

    private static List<Controller> getTasks(ConsoleHelper consoleHelper) {
        List<Controller> tasks = new ArrayList<>();
        ChessBoardService chessBoardService = new ChessBoardService();
        ChessBoardValidator chessBoardValidator = new ChessBoardValidator();
        tasks.add(new ChessBoardController(consoleHelper, chessBoardService, chessBoardValidator));

        EnvelopeService envelopeService = new EnvelopeService();
        EnvelopeValidator envelopeValidator = new EnvelopeValidator();
        tasks.add(new EnvelopeController(consoleHelper, envelopeService, envelopeValidator));

        TriangleService triangleService = new TriangleService();
        TriangleValidator triangleValidator = new TriangleValidator();
        tasks.add(new TriangleController(consoleHelper, triangleService, triangleValidator));

        FileWorkerService fileWorkerService = new FileWorkerService();
        FileParserService fileParserService = new FileParserService(fileWorkerService);
        FileParserValidator fileParserValidator = new FileParserValidator();
        tasks.add(new FileParserController(consoleHelper, fileParserService, fileParserValidator));

        NumberInWordsService numberInWordsService = new NumberInWordsService(new NumberInWordsRu());
        NumberInWordsValidator numberInWordsValidator = new NumberInWordsValidator();
        tasks.add(new NumberInWordsController(consoleHelper, numberInWordsService, numberInWordsValidator));

        HappyTicketsServices happyTicketsServices = new HappyTicketsServices();
        HappyTicketsValidator happyTicketsValidator = new HappyTicketsValidator();
        tasks.add(new HappyTicketsController(consoleHelper, happyTicketsServices, happyTicketsValidator,
                fileWorkerService));

        NumericSequenceServices numericSequenceServices = new NumericSequenceServices();
        NumericSequenceValidator numericSequenceValidator = new NumericSequenceValidator();
        tasks.add(new NumericSequenceController(consoleHelper, numericSequenceServices, numericSequenceValidator));

        FibonacciNumbersService fibonacciNumbersService = new FibonacciNumbersService();
        FibonacciNumbersValidator fibonacciNumbersValidator = new FibonacciNumbersValidator();
        tasks.add(new FibonacciNumbersController(consoleHelper, fibonacciNumbersService, fibonacciNumbersValidator));

        ExponentiationService exponentiationService = new ExponentiationService();
        ExponentiationValidator exponentiationValidator = new ExponentiationValidator();
        tasks.add(new ExponentiationControllers(consoleHelper, exponentiationService, exponentiationValidator));
        return tasks;
    }
}
