package task3.services;

import org.junit.Before;
import org.junit.Test;
import task3.models.Triangle;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TriangleServiceTest {
    private TriangleService triangleService;

    @Before
    public void setUp() {
        triangleService = new TriangleService();
    }

    @Test
    public void sortTriangles() {
        //GIVEN
        List<Triangle> triangles = new ArrayList<>();
        triangles.add(new Triangle("", 2, 3, 4));
        triangles.add(new Triangle("", 3, 4, 3));
        triangles.add(new Triangle("", 4, 4, 3));

        //WHEN
        triangleService.sortTriangles(triangles);

        //THEN
        boolean isSorted = triangles.get(0).getArea() > triangles.get(1).getArea()
                && triangles.get(1).getArea() > triangles.get(2).getArea();
        assertTrue(isSorted);
    }
}