package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapeList = new ArrayList<>();

    void addFigure(Shape shape) {
        shapeList.add(shape);
    }

    void removedFigure(Shape shape) {
        shapeList.remove(shape);
    }

    /**
     * @return element na pozycji <i>n</i> listy
     */
    Shape getFigure(int n) {
        if (n >= 0 && n < shapeList.size()) {
            return shapeList.get(n);
        } else {
            return null;
        }
    }

    /**
     * @return nazwy wszytkich figur w postaci <i>Stringa</i>
     */
    String showFigures() {
        String result = "";
        for (int i = 0; i < shapeList.size(); i++) {
            result += shapeList.get(i).getShapeName();
            if (i != shapeList.size() - 1) {
                result += ", ";
            }
        }
        return result;
    }
}
