package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1786 {

    static int[] getPI(String pattern) {
        int n = pattern.length();
        int[] pi = new int[n];

        // j는 접두사 index, i는 접미사 index
        int j = 0;
        for (int i = 1; i < n; i++) {

            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }

        return pi;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String origin = br.readLine();
        String pattern = br.readLine();

        int[] pi = getPI(pattern);
        int pn = pattern.length();

        int j = 0;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0, end = origin.length(); i < end; i++) {

            while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (origin.charAt(i) == pattern.charAt(j)) {
                if (j == pn - 1) {
                    cnt++;
                    sb.append(i - pn + 2 +" ");
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}