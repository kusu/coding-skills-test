package coding.test.ctci.array;

import java.util.Arrays;

public class ZeroMatrix {

    public static void zeroMatrix(int[][] matrix) {

        int[] rowTracker = new int[matrix.length];
        int[] colTracker = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j] == 0) {

                    if (rowTracker[i] == 0) {
                        setRowZero(i, matrix);
                        rowTracker[i] = 1;
                    }

                    if (colTracker[j] == 0) {
                        setColZero(j, matrix);
                        colTracker[j] = 1;
                    }

                }

            }

        }

    }

    //[1,2,3]
    //[4,5,6]
    public static void setRowZero(int row, int[][] matrix) {


        //set row to zero
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = -1;
        }

    }

    //[1,2,3]
    //[4,5,6]
    public static void setColZero(int col, int[][] matrix) {

        // set col to zero
        for (int j = 0; j < matrix.length; j++) {
            matrix[j][col] = -1;
        }

    }

    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            System.out.println(Arrays.toString(matrix[i]));

        }
    }

    public static void main(String[] args) {

        int[][] matrix = new int[4][4];

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {
                matrix[i][j] = i + j;
            }
        }

        printMatrix(matrix);

        zeroMatrix(matrix);

        printMatrix(matrix);
    }
}
