package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] fruit = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fruit[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        int[] countFruit = new int[10];
        int useFruitType = 0;

        int start = 0;
        int end = 0;
        while (end < n && start <= end) {

            if (countFruit[fruit[end]]++ == 0)
                useFruitType++;

            while (useFruitType > 2) {

                if (--countFruit[fruit[start]] == 0) {
                    useFruitType--;
                }

                start++;
            }

            end++;
            max = Math.max(max, end - start);
        }

        System.out.println(max);
    }
}
