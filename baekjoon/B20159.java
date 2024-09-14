package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20159 {

    static int N;
    static long[] arr;

    static long[] odd; // 홀수 합
    static long[] even; // 짝수 합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        odd = new long[N];
        even = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());

            if (i == 0) {
                even[i] = arr[i];
                continue;
            }

            if (i % 2 == 1) {
                if (i > 2) {
                    odd[i] = odd[i - 2] + arr[i];
                } else {
                    odd[i] = arr[i];
                }
            } else {
                even[i] = even[i - 2] + arr[i];
            }

        }

        long answer = even[N - 2];
        for (int i = 0; i < N; i++) {
            long temp = 0;

            if (i == 0) {
                temp = odd[N - 1];
                answer = Math.max(answer, temp);
                continue;
            }

            if (i % 2 == 0) {
                temp = odd[N - 1] - odd[i - 1] + even[i - 2];
            } else {
                temp = odd[N - 1] - odd[i] + arr[i] + even[i - 1] - arr[N - 1];
            }

            answer = Math.max(answer, temp);
        }

        System.out.println(answer);
    }
}
