public class LargestLocalValuesInAMatrix_2373 {

    public static void main(String[] args) {

        int[][] matrix2 = {
                {9, 9, 8, 1},
                {5, 6, 2, 6},
                {8, 2, 6, 4},
                {6, 2, 2, 2}
        };

        int[][] matrix = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };


        int[][] result = largestLocal(matrix);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(result[i][j]);
            }

        }
    }

    public static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n - 2][n - 2];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                int min = 0;

                for (int k = i; k <= i + 2; k++) {
                    for (int l = j; l <= j + 2; l++) {
                        if (grid[k][l] > min) {
                            min = grid[k][l];
                        }
                    }
                }
                result[i][j] = min;
            }
        }


        return result;


    }


}