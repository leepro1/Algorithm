package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2230 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int answer = arr[N - 1] - arr[0];

        int start = 0;
        int end = 1;

        while (start < end) {
            if (end >= N) {
                break;
            }

            int temp = arr[end] - arr[start];

            if (temp < M) {
                end++;
            } else if (temp == M) {
                answer = M;
                break;
            } else {
                answer = Math.min(answer, temp);
                if (++start == end) {
                    end++;
                }
            }
        }

        System.out.println(answer);
    }
}
