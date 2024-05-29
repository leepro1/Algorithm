package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int mean = (int) Math.round(n * 0.15);

        int sum = 0;
        for (int i = mean; i < n - mean; i++) {
            sum += arr[i];
        }

        System.out.println((int) Math.round(sum / (n - 2.0 * mean)));
    }
}
