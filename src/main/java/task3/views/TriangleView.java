package task3.views;

import task3.controllers.TriangleController;
import views.ConsoleHelper;

import java.util.ArrayList;

public class TriangleView {
    private final ConsoleHelper consoleHelper;
    private final TriangleController triangleController;
    private final ArrayList<String> triangleParameters;

    public TriangleView(ConsoleHelper consoleHelper) {
        this.consoleHelper = consoleHelper;
        this.triangleController = new TriangleController();
        this.triangleParameters = new ArrayList<>();
    }

    public void show() {
        boolean isRunning = true;
        while (isRunning) {
            showMenu();
            switch (consoleHelper.read()) {
                case "1":
                    readTriangleParameters();
                    break;
                case "2":
                    showSortedTriangle();
                    triangleParameters.clear();
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

    private void readTriangleParameters() {
        String parameters = consoleHelper.read("Enter the parameters of the triangle in the format: " +
                "<name>, <side>, <side>, <side>");
        triangleParameters.add(parameters);
    }

    private void showSortedTriangle() {
        ArrayList<String> sortingTriangles = triangleController.getResultOfSortingTriangles(triangleParameters);
        consoleHelper.write("============= Triangles list: ===============");
        for (int i = 0; i < sortingTriangles.size(); i++) {
            consoleHelper.write((i + 1) + "." + sortingTriangles.get(i));
        }
    }

    public void showMenu() {
        consoleHelper.write("1. Add triangle");
        consoleHelper.write("2. Show result");
        consoleHelper.write("R. Return");
    }
}
