package task6.controllers;

import exceptions.ValidationException;
import services.FileWorkerService;
import task6.services.HappyTicketsServices;
import task6.validators.HappyTicketsValidator;
import views.ConsoleHelper;

import java.io.IOException;

public class HappyTicketsController {
    private final ConsoleHelper consoleHelper;
    private final HappyTicketsValidator happyTicketsValidator;
    private final HappyTicketsServices happyTicketsServices;
    private final FileWorkerService fileWorkerService;

    public HappyTicketsController(ConsoleHelper consoleHelper) {
        this.consoleHelper = consoleHelper;
        this.happyTicketsValidator = new HappyTicketsValidator();
        this.happyTicketsServices = new HappyTicketsServices();
        this.fileWorkerService = new FileWorkerService();
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            switch (consoleHelper.read()) {
                case "1":
                    countNumberOfLuckyTickets();
                    break;
                case "R":
                    isRunning = false;
                    break;
                default:
                    consoleHelper.write("Wrong input!");
                    break;
            }
        }
    }

    private void showMenu() {
        consoleHelper.write("1. Count the number of lucky tickets");
        consoleHelper.write("R. Return to main menu");
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
