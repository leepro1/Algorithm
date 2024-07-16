package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14891 {

    static int[][] gear;
    static int[] rotate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 마지막 열은 방향이다.
        gear = new int[5][9];
        for (int i = 1; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = str.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            rotate = new int[5];
            rotate[target] = direction;
            rotation(target, direction);

            for (int i = 1; i < 5; i++) {
                if (rotate[i] != 0)
                    gear[i][8] += rotate[i];

                if (gear[i][8] > 0)
                    gear[i][8] -= 8;
            }
        }

        int bonus = 1;
        int answer = 0;
        for (int i = 1; i < 5; i++) {
            answer += (gear[i][(-gear[i][8]) % 8]) * bonus;

            bonus *= 2;
        }

        System.out.println(answer);
    }

    public static void rotation(int target, int direction) {

        if (target < 4 && rotate[target + 1] == 0 && gear[target][(2 - gear[target][8]) % 8] != gear[target + 1][(6 - gear[target + 1][8]) % 8]) {
            rotate[target + 1] = -direction;
            rotation(target + 1, -direction);
        }

        if (target > 1 && rotate[target - 1] == 0 && gear[target][(6 - gear[target][8]) % 8] != gear[target - 1][(2 - gear[target - 1][8]) % 8]) {
            rotate[target - 1] = -direction;
            rotation(target - 1, -direction);
        }
    }


}
