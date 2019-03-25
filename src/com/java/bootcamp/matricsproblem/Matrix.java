package com.java.bootcamp.matricsproblem;

class Matrix {

    private int[][] matrix;

    Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    void printAllElement() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("i,j" + i + j + " and element is " + this.matrix[i][j]);

            }
        }
    }

    Matrix multiply(Matrix secondMatrix) {
        int[][] result = new int [this.matrix.length][this.matrix.length];

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix.length; j++) {
                for (int k = 0; k < this.matrix.length; k++) {
                    result[i][j] += this.matrix[i][k] * secondMatrix.matrix[k][j];
                }
            }
        }
        return new Matrix(result);
    }

    Matrix add(Matrix secondMatrix) {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < secondMatrix.matrix.length; j++) {
                this.matrix[i][j] += secondMatrix.matrix[i][j];
            }
        }
        return this;
    }

    Matrix subtraction(Matrix secondMatrix) {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < secondMatrix.matrix.length; j++) {
                this.matrix[i][j] -= secondMatrix.matrix[i][j];
            }
        }
        return this;
    }

    int[][] getMatrix() {
        return this.matrix;
    }
}

