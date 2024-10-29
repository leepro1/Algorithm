package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3020 {

    static int N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[] bottomStoneList = new int[N / 2];
        int[] topStoneList = new int[N / 2];

        for (int i = 0; i < N / 2; i++) {
            int tempBottom = Integer.parseInt(br.readLine());
            int tempTop = Integer.parseInt(br.readLine());

            bottomStoneList[i] = tempBottom;
            topStoneList[i] = tempTop;
        }

        Arrays.sort(bottomStoneList);
        Arrays.sort(topStoneList);

        int answerStone = N;
        int answerCnt = 0;

        for (int i = 1; i <= H; i++) {
            int stone = binarySearch(i, bottomStoneList) + binarySearch(H - i + 1, topStoneList);

            if (answerStone == stone) {
                answerCnt++;
            } else if (answerStone > stone) {
                answerCnt = 1;
                answerStone = stone;
            }

        }

        System.out.println(answerStone + " " + answerCnt);
    }

    static int binarySearch(int h, int[] arr) {
        int start = 0;
        int end = N / 2;

        while (start < end) {
            int mid = (start + end) / 2;

            if (arr[mid] >= h) {
                end = mid;
            } else {
                start = mid + 1;
            }

        }

        return N / 2 - end;
    }
}
