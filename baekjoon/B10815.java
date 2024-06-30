package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10815 {

    static int[] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        card = new int[N];
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(search(target)).append(" ");
        }

        System.out.println(sb);
    }

    static int search(int target) {
        int start = 0;
        int end = card.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (target == card[mid]) {
                return 1;
            } else if (target < card[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }
}
