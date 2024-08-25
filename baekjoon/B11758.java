package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] xList = new int[3];
        int[] yList = new int[3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            xList[i] = Integer.parseInt(st.nextToken());
            yList[i] = Integer.parseInt(st.nextToken());
        }

        int a = xList[0] * yList[1] + xList[1] * yList[2] + xList[2] * yList[0];
        int b = xList[1] * yList[0] + xList[2] * yList[1] + xList[0] * yList[2];

        if (a - b > 0) {
            System.out.println(1);
        } else if (a < b) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }

    }
}
