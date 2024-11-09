package inflearn;

public class MatrixRotation {

    public static void rotateMatrix(int[][] matrix, int angle) {
        int n = matrix.length;

        // 각도에 따라 회전 처리
        switch (angle) {
            case 90:
                transpose(matrix);
                horizontalFlip(matrix);
                break;
            case -90:
                transpose(matrix);
                verticalFlip(matrix);
                break;
            case 180:
                rotate180(matrix);
                break;
        }
    }

    // 전치(transpose) 함수
    private static void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // 좌우 반전 (horizontal flip) 함수
    private static void horizontalFlip(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    // 상하 반전 (vertical flip) 함수
    private static void verticalFlip(int[][] matrix) {
        int n = matrix.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n / 2; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }
    }

    // 180도 회전 함수
    private static void rotate180(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = temp;
            }
        }

        // 중간 행이 존재하는 홀수 크기 행렬일 경우, 중간 행을 좌우 반전
        if (n % 2 == 1) {
            int mid = n / 2;
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[mid][j];
                matrix[mid][j] = matrix[mid][n - 1 - j];
                matrix[mid][n - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // 예시: 90도 시계 방향 회전
        rotateMatrix(matrix, 90);
        printMatrix(matrix);

        // 예시: 90도 반시계 방향 회전
        rotateMatrix(matrix, -90);
        printMatrix(matrix);

        // 예시: 180도 회전
        rotateMatrix(matrix, 180);
        printMatrix(matrix);
    }

    // 행렬 출력 함수
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
