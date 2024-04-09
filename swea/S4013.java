package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4013 {

    static Magnet[] magnetList;
    static boolean[] rotationList;

    static class Magnet {
        int index = 0;
        boolean[] flag = new boolean[8]; // N극이 true
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            magnetList = new Magnet[4];
            for (int i = 0; i < 4; i++) {
                magnetList[i] = new Magnet();
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    if (st.nextToken().equals("0"))
                        magnetList[i].flag[j] = true;
                }
            }

            while (n-- > 0) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken()) - 1;
                int direction = Integer.parseInt(st.nextToken());

                rotationList = new boolean[4];
                rotationList[num] = true;
                checkRotation(num);

                rotation(num, direction);
            }

            int answer = 0;
            for (int i = 0; i < 4; i++) {
                if (!magnetList[i].flag[magnetList[i].index]) {
                    answer |= (1 << i);
                }
            }

            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    static void checkRotation(int num) {
        //왼쪽 체크
        for (int i = num - 1; i >= 0; i--) {
            if (magnetList[i].flag[(magnetList[i].index + 2) % 8] != magnetList[i + 1].flag[(magnetList[i + 1].index + 6) % 8])
                rotationList[i] = true;
            else
                break;
        }

        //오른쪽 체크
        for (int i = num + 1; i <= 3; i++) {
            if (magnetList[i - 1].flag[(magnetList[i - 1].index + 2) % 8] != magnetList[i].flag[(magnetList[i].index + 6) % 8])
                rotationList[i] = true;
            else
                break;
        }
    }

    static void rotation(int num, int direction) {

        for (int i = 0; i < 4; i++) {
            if (rotationList[i]) {
                if (Math.abs(num - i) % 2 == 1)
                    changeIndex(i, -direction);
                else
                    changeIndex(i, direction);
            }
        }
    }

    static void changeIndex(int n, int direction) {
        magnetList[n].index -= direction;
        if (magnetList[n].index == -1)
            magnetList[n].index = 7;
        magnetList[n].index %= 8;
    }
}

