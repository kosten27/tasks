package task3.controllers;

import exceptions.ValidationException;
import task3.models.Triangle;
import task3.services.TriangleService;
import task3.validators.TriangleValidator;

import java.util.ArrayList;

public class TriangleController {
    private final TriangleService triangleService;
    private final TriangleValidator triangleValidator;

    public TriangleController() {
        triangleService = new TriangleService();
        triangleValidator = new TriangleValidator();
    }

    public ArrayList<String> getResultOfSortingTriangles(ArrayList<String> triangleParameters) {
        ArrayList<Triangle> triangles = new ArrayList<>();
        for (int i = 0; i < triangleParameters.size(); i++) {
            String parameters = triangleParameters.get(i);
            try {
                triangleValidator.validateFormatOfParameters(parameters);
            } catch (ValidationException e) {
                ArrayList<String> result = new ArrayList<>();
                result.add(e.getMessage());
                return result;
            }
            String[] splitParameters = parameters.split(",");
            int minNumberOfParameters = 4;
            if (splitParameters.length >= minNumberOfParameters) {
                String name = splitParameters[0];
                double side1 = Double.parseDouble(splitParameters[1]);
                double side2 = Double.parseDouble(splitParameters[2]);
                double side3 = Double.parseDouble(splitParameters[3]);
                try {
                    triangleValidator.validatePossibilityOfTriangle(side1, side2, side3);
                } catch (ValidationException e) {
                    ArrayList<String> result = new ArrayList<>();
                    result.add(e.getMessage());
                    return result;
                }
                triangles.add(new Triangle(name, side1, side2, side3));
            }
        }
        triangleService.sortTriangles(triangles);
        return getArrayOfString(triangles);
    }

    private ArrayList<String> getArrayOfString (ArrayList<Triangle> triangles) {
        ArrayList<String> strings = new ArrayList<>();
        for (Triangle triangle : triangles) {
            strings.add(triangle.toString());
        }
        return strings;
    }
}
