import views.ConsoleHelper;
import views.TaskMenu;

public class App {
    public static void main(String[] args) {
        ConsoleHelper consoleHelper = new ConsoleHelper();
        TaskMenu taskMenu = new TaskMenu(consoleHelper);
        taskMenu.run();
        consoleHelper.close();
    }
}
