package com.java.bootcamp.matricsproblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    @Test
    void shouldReturnMatrixAfterAddingWithAnotherMatrix() {
        int[][] a = {{1,2},{3,4}};
        Matrix matrix = new Matrix(a);

        int[][] b = {{3,2},{-3,4}};
        Matrix matrix1 = new Matrix(b);

        int[][] c = {{4,4},{0,8}};
        Matrix expected = new Matrix(c);
        assertArrayEquals(expected.getMatrix(), matrix.add(matrix1).getMatrix());
    }

    @Test
    void shouldReturnMatrixAfterSubtractingWithAnotherMatrix() {
        int[][] a = {{1,2},{3,4}};
        Matrix matrix = new Matrix(a);

        int[][] c = {{2,1},{-1,1}};
        Matrix matrix1 = new Matrix(c);

        int[][] d = {{-1,1},{4,3}};
        Matrix expected = new Matrix(d);

        assertArrayEquals(expected.getMatrix(), matrix.subtraction(matrix1).getMatrix());
    }

    @Test
    void shouldReturnMatrixAfterMultiplyingWithAnotherMatrix() {
        int[][] a = {{1,0},{0,1}};
        Matrix matrix = new Matrix(a);

        int[][] c = {{2,1},{2,4}};
        Matrix matrix1 = new Matrix(c);

        int[][] d = {{2,1},{2,4}};
        Matrix expected = new Matrix(d);

        assertArrayEquals(expected.getMatrix(), matrix.multiply(matrix1).getMatrix());
    }

    @Test
    void shouldReturnMatrixAfterMultiplying3by3MaticsWithAnotherMatrix() {
        int[][] a = {{1,0,0},{0,1,0},{0,0,1}};
        Matrix matrix = new Matrix(a);

        int[][] c = {{2,1,9},{2,4,3},{4,3,8}};
        Matrix matrix1 = new Matrix(c);

        int[][] d = {{2,1,9},{2,4,3},{4,3,8}};
        Matrix expected = new Matrix(d);

        assertArrayEquals(expected.getMatrix(), matrix.multiply(matrix1).getMatrix());
    }


}
