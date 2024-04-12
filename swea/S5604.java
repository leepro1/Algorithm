package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5604 {

    static long answer;

    static void sum(long n, long mul) {
        while (n > 0) {
            answer += (n % 10) * mul;
            n /= 10;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long start, end;

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            start = Long.parseLong(st.nextToken());
            end = Long.parseLong(st.nextToken());

            answer = 0;
            long mul = 1; // 자릿수

            while (start <= end) {
                if (start > end || (start == 0 && end == 0))
                    break;

                //start % 10 이 0이 될때까지 start++을 하며 start 행의 값 계산
                while (start % 10 != 0 && start <= end)
                    sum(start++, mul);

                //end % 10 이 9가 될때까지 end--을 하며 end 행의 값 계산
                while (end % 10 != 9 && start <= end)
                    sum(end--, mul);

                start /= 10;
                end /= 10;

                long m = (end - start + 1) * mul;
                for (int i = 1; i < 10; i++)
                    answer += m * i;

                mul *= 10;
            }

            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }
}
