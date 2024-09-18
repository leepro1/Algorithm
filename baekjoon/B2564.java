package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2564 {

    static int R, C, N;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        int[] dists = new int[N + 1];
        while (N-- >= 0) {
            st = new StringTokenizer(br.readLine());

            int direction = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            int value = 0;
            switch (direction) {
                case 1:
                    value = dist;
                    break;
                case 2:
                    value = 2 * R + C - dist;
                    break;
                case 3:
                    value = 2 * (R + C) - dist;
                    break;
                case 4:
                    value = R + dist;
                    break;
            }

            dists[N + 1] = value;
        }

        for (int i = 1; i < dists.length; i++) {
            int cw = Math.abs(dists[0] - dists[i]);
            int ccw = 2 * (R + C) - cw;
            answer += Math.min(cw, ccw);
        }

        System.out.println(answer);
    }
}
