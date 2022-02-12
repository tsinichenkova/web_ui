package org.web.ui.lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTest {
    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @DisplayName("Проверка корректных значений для расчета площади треугольника")
    @ParameterizedTest
    @CsvSource({ "5, 3, 4, 6", "20, 21, 29, 210", "5, 12, 13, 30" })
    void checkAreaTriangle(int a, int b, int c, double expectedArea) throws TriangleExeption {
        logger.info("Передан треугольник со сторонами: " + a + "," + b + "," + c);
        Triangle triangle = new Triangle(a, b, c);
        double area = triangle.areaTriangle();
        assertEquals(expectedArea, area, "Площадь рассчитана неверно");
    }

    @DisplayName("Проверка передачи стороны равной нулю")
    @ParameterizedTest
    @CsvSource({ "0, 3, 4", "20, 0, 29", "5, 12, 0", "0, 0, 0" })
    void checkNull(int a, int b, int c){
        logger.info("Передан треугольник со сторонами: " + a + "," + b + "," + c);
        Triangle triangle = new Triangle(a, b, c);
        Assertions.assertThrows(TriangleExeption.class, triangle::areaTriangle, "нет исключения");
    }

    @DisplayName("Проверка передачи отрицательного значения")
    @ParameterizedTest
    @CsvSource({ "-1, 3, 4", "20, -2, 29", "5, 12, -3", "-1, -2, -3" })
    void checkNegativeMeaning(int a, int b, int c){
        logger.info("Передан треугольник со сторонами: " + a + "," + b + "," + c);
        Triangle triangle = new Triangle(a, b, c);
        Assertions.assertThrows(TriangleExeption.class, triangle::areaTriangle, "нет исключения");
    }

    @DisplayName("Проверка передачи значений, которые не являются треугольником")
    @ParameterizedTest
    @CsvSource({ "2, 4, 100", "100, 12, 13", "4, 50, 3"})
    void checkInvalidValues(int a, int b, int c){
        logger.info("Передан треугольник со сторонами: " + a + "," + b + "," + c);
        Triangle triangle = new Triangle(a, b, c);
        Assertions.assertThrows(TriangleExeption.class, triangle::areaTriangle, "нет исключения");
    }

}