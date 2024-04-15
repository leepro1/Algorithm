package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S8458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int n;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());

            int max = 0;
            int answer = 0;
            int flag = 0; // 홀짝을 판단하는 변수
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int temp = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
                if (i == 0)
                    flag = temp % 2;

                if (temp % 2 == flag)
                    max = Math.max(max, temp);
                else
                    answer = -1;
            }

            if (answer != -1) {
                int checkSum = 0;

                for (int i = 0; true; i++) {
                    checkSum += i;

                    if (max <= checkSum && checkSum % 2 == flag) {
                        answer = i;
                        break;
                    }
                }
            }

            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }
}
