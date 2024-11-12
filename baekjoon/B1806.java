package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1806 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = arr[0];
        int start = 0;
        int end = 0;
        int answer = N + 1;

        while (start <= end) {

            if (sum >= S) {
                answer = Math.min(answer, end - start + 1);
                sum -= arr[start];
                start++;
            } else {
                end++;

                if (end >= N) {
                    break;
                }

                sum += arr[end];
            }
        }

        System.out.println(answer == N + 1 ? 0 : answer);
    }
}
