package task3.controllers;

import exceptions.ValidationException;
import application.Controller;
import task3.models.Triangle;
import task3.services.TriangleService;
import task3.validators.TriangleValidator;
import application.ConsoleHelper;
import java.util.ArrayList;
import java.util.List;

public class TriangleController implements Controller {
    private final ConsoleHelper consoleHelper;
    private final TriangleValidator triangleValidator;
    private final TriangleService triangleService;

    public TriangleController(ConsoleHelper consoleHelper, TriangleService triangleService,
                              TriangleValidator triangleValidator) {
        this.consoleHelper = consoleHelper;
        this.triangleValidator = triangleValidator;
        this.triangleService = triangleService;
    }

    public void run() {
        List<Triangle> triangles = readTriangles();
        triangleService.sortTriangles(triangles);
        showTriangles(triangles);
        consoleHelper.read("Press Enter to continue.");
    }

    @Override
    public String getName() {
        return "Sort triangles";
    }

    private List<Triangle> readTriangles() {
        List<Triangle> triangles = new ArrayList<>();
        String answer;
        do {
            triangles.add(readTriangle());
            answer = consoleHelper.read("Add another triangle? (yes/y)");
        } while ("yes".equals(answer) || "y".equals(answer));
        return triangles;
    }

    private Triangle readTriangle() {
        Triangle triangle = null;
        do {
            String parameters = consoleHelper.read("Enter the parameters of the triangle in the format: " +
                    "<name>, <side>, <side>, <side>");
            String[] arraysOfParameters = parameters.split(",");
            if (arraysOfParameters.length == 4) {
                try {
                    String name = arraysOfParameters[0];
                    double side1 = Double.parseDouble(arraysOfParameters[1]);
                    double side2 = Double.parseDouble(arraysOfParameters[2]);
                    double side3 = Double.parseDouble(arraysOfParameters[3]);
                    triangleValidator.validatePossibilityOfTriangle(side1, side2, side3);
                    triangle = new Triangle(name, side1, side2, side3);
                } catch (NumberFormatException e) {
                    consoleHelper.write("Number format error");
                } catch (ValidationException e) {
                    consoleHelper.write(e.getMessage());
                }
            }
        } while (triangle == null);

        return triangle;
    }

    private void showTriangles(List<Triangle> triangles) {
        consoleHelper.write("============= Triangles list: ===============");
        for (int i = 0; i < triangles.size(); i++) {
            consoleHelper.write((i + 1) + "." + triangles.get(i).toString());
        }
    }
}
