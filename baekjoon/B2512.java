package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] requestMoney = new int[N];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            requestMoney[i] = Integer.parseInt(st.nextToken());
            sum += requestMoney[i];
        }

        int M = Integer.parseInt(br.readLine());

        Arrays.sort(requestMoney);

        if (M >= sum) {
            System.out.println(requestMoney[N - 1]);
        } else {
            int start = 0;
            int end = requestMoney[N - 1];
            int answer = 0;

            while (start <= end) {
                int mid = (start + end) / 2;

                int tempSum = 0;
                for (int i = 0; i < N; i++) {
                    if (requestMoney[i] <= mid) {
                        tempSum += requestMoney[i];
                    } else {
                        tempSum += mid;
                    }
                }

                if (tempSum <= M) {
                    answer = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            System.out.println(answer);
        }
    }
}
