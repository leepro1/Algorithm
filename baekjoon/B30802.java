package baekjoon;

import java.util.*;
import java.io.*;

public class B30802 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] shirts = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            shirts[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i < 6; i++) {
            count += shirts[i] / t;
            if (shirts[i] % t != 0) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println(n / p + " " + n % p);
    }
}
