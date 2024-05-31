package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] arr = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }


        int[][] maxDp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + arr[i][0];

            int tempMax = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]);
            maxDp[i][1] = Math.max(tempMax, maxDp[i - 1][2]) + arr[i][1];

            maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + arr[i][2];
        }

        int[][] minDp = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            minDp[i][0] = Math.min(minDp[i - 1][0], minDp[i - 1][1]) + arr[i][0];

            int tempMin = Math.min(minDp[i - 1][0], minDp[i - 1][1]);
            minDp[i][1] = Math.min(tempMin, minDp[i - 1][2]) + arr[i][1];

            minDp[i][2] = Math.min(minDp[i - 1][1], minDp[i - 1][2]) + arr[i][2];
        }

        int max = maxDp[n][0];
        int min = minDp[n][0];
        for (int i = 1; i < 3; i++) {
            max = Math.max(max, maxDp[n][i]);
            min = Math.min(min, minDp[n][i]);
        }

        System.out.println(max + " " + min);
    }
}
