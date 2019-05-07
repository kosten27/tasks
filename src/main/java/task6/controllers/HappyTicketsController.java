package task6.controllers;

import exceptions.ValidationException;
import application.Controller;
import services.FileWorkerService;
import task6.services.HappyTicketsServices;
import task6.validators.HappyTicketsValidator;
import application.ConsoleHelper;

import java.io.IOException;

public class HappyTicketsController implements Controller {
    private final ConsoleHelper consoleHelper;
    private final HappyTicketsValidator happyTicketsValidator;
    private final HappyTicketsServices happyTicketsServices;
    private final FileWorkerService fileWorkerService;

    public HappyTicketsController(ConsoleHelper consoleHelper, HappyTicketsServices happyTicketsServices,
                                  HappyTicketsValidator happyTicketsValidator, FileWorkerService fileWorkerService) {
        this.consoleHelper = consoleHelper;
        this.happyTicketsValidator = happyTicketsValidator;
        this.happyTicketsServices = happyTicketsServices;
        this.fileWorkerService = fileWorkerService;
    }

    public void run() {
        countNumberOfLuckyTickets();
        consoleHelper.read("Press Enter to continue.");
    }

    @Override
    public String getName() {
        return "Happy tickets";
    }

    private void countNumberOfLuckyTickets() {
        String filePath = consoleHelper.read("Enter the path to the text file.");
        try {
            String fileContents = fileWorkerService.getFileContents(filePath);
            happyTicketsValidator.validateFileContents(fileContents);
            long numberOfLuckyTickets = happyTicketsServices.countNumberOfLuckyTickets(fileContents);
            consoleHelper.write("Number of happy tickets is " + numberOfLuckyTickets);
        } catch (IOException | ValidationException e) {
            consoleHelper.write(e.getMessage());
        }
    }
}
