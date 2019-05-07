package application;

import java.util.List;

public class TaskMenu {
    private final ConsoleHelper consoleHelper;
    private final List<Controller> tasks;

    public TaskMenu(ConsoleHelper consoleHelper, List<Controller> tasks) {
        this.consoleHelper = consoleHelper;
        this.tasks = tasks;
    }

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            String inputValue = consoleHelper.read();
            if ("E".equals(inputValue)) {
                isRunning = false;
            } else {
                try {
                    int intValue = Integer.parseInt(inputValue);
                    if (intValue >=0 && intValue < tasks.size()) {
                        tasks.get(intValue).run();
                    } else {
                        consoleHelper.write("Wrong input!");
                    }
                } catch (NumberFormatException e) {
                    consoleHelper.write("Wrong input!");
                }
            }
        }
    }

    private void showMenu() {
        for (int i = 0; i < tasks.size(); i++) {
            consoleHelper.write(i + ". " + tasks.get(i).getName());
        }
        consoleHelper.write("E. Exit");
    }
}
