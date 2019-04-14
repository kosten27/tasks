package task2;

import task2.controllers.ViewController;
import task2.controllers.impl.ConsoleControllerImpl;
import task2.validators.ValidationService;
import task2.validators.impl.ValidationServiceImpl;

public class App {
    public static void main(String[] args) {
        ValidationService validationService =  new ValidationServiceImpl();
        ViewController viewController = new ConsoleControllerImpl(validationService);
        viewController.runEnvelopeComparison();
    }
}
