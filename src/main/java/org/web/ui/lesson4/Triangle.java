package org.web.ui.lesson4;

public class Triangle {
    private final int a;
    private final int b;
    private final int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private void checkValid() throws TriangleExeption {
        if (!(a + b > c && b + c > a && a + c > b)) {
            throw new TriangleExeption("Это не треугольник");
        }
    }

    private void checkCorrect() throws TriangleExeption {
        if (!(this.a > 0 | this.b > 0 | this.c > 0)) {
            throw new TriangleExeption("Введены некорректные значения треугольника");
        }
    }

    public double areaTriangle() throws TriangleExeption {
        checkCorrect();
        checkValid();
        int p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
