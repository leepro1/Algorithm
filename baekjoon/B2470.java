package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] matterList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            matterList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(matterList);

        int start = 0;
        int end = N - 1;
        int gap = Integer.MAX_VALUE;

        int answerA = 0;
        int answerB = 0;
        while (start < end) {
            int temp = matterList[start] + matterList[end];

            if (Math.abs(temp) < gap) {
                gap = Math.abs(temp);
                answerA = matterList[start];
                answerB = matterList[end];
            }

            if (temp == 0) {
                break;
            } else if (temp < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(answerA + " " + answerB);
    }
}