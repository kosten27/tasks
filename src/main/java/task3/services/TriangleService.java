package task3.services;

import task3.models.Triangle;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TriangleService {

    public void sortTriangles(List<Triangle> triangles) {
        Comparator<Triangle> comparator = (t1, t2) -> {
            if (t1.getArea() < t2.getArea()) {
                return 1;
            } else if (t1.getArea() > t2.getArea()) {
                return -1;
            } else {
                return 0;
            }
        };
        Collections.sort(triangles, comparator);
    }
}
