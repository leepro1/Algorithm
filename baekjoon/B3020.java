package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B3020 {

    static int N, H;
    static Map<Integer, Integer> bottomStone;
    static Map<Integer, Integer> topStone;
    static ArrayList<Integer> bottomStoneList;
    static ArrayList<Integer> topStoneList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        bottomStone = new HashMap<>();
        topStone = new HashMap<>();
        bottomStoneList = new ArrayList<>();
        topStoneList = new ArrayList<>();

        for (int i = 0; i < N / 2; i++) {
            int tempBottom = Integer.parseInt(br.readLine());
            int tempTop = Integer.parseInt(br.readLine());

            if (bottomStone.containsKey(tempBottom)) {
                bottomStone.put(tempBottom, bottomStone.get(tempBottom) + 1);
            } else {
                bottomStone.put(tempBottom, 1);
                bottomStoneList.add(tempBottom);
            }

            if (topStone.containsKey(tempTop)) {
                topStone.put(tempTop, topStone.get(tempTop) + 1);
            } else {
                topStone.put(tempTop, 1);
                topStoneList.add(tempTop);
            }

        }

        Collections.sort(bottomStoneList);
        Collections.sort(topStoneList);

        int answerStone = N;
        int answerCnt = 0;

        for (int i = 1; i <= H; i++) {
            int stone = 0;

            for (int bottom : bottomStoneList) {
                if (H - bottom < i) {
                    stone += bottomStone.get(bottom);
                }
            }

            for (int top : topStoneList) {
                if (top >= i) {
                    stone += topStone.get(top);
                }
            }

            if (answerStone == stone) {
                answerCnt++;
            } else if (answerStone > stone) {
                answerCnt = 1;
                answerStone = stone;
            }

        }

        System.out.println(answerStone + " " + answerCnt);
    }
}
