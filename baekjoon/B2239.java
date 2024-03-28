package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2239 {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        sudoku(0, 0);
    }

    static void sudoku(int x, int y) {
        if (x == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }

        if (map[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(x, y, i)) {
                    map[x][y] = i;
                    if (y == 8)
                        sudoku(x + 1, 0);
                    else
                        sudoku(x, y + 1);
                }
            }
            map[x][y] = 0;
        } else {
            if (y == 8)
                sudoku(x + 1, 0);
            else
                sudoku(x, y + 1);
        }
    }

    static boolean check(int x, int y, int val) {
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == val)
                return false;

            if (map[i][y] == val)
                return false;
        }

        for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
                if (map[i][j] == val)
                    return false;
            }
        }

        return true;
    }
}