package programmers;

import java.util.*;

public class P42578 {

    static class Solution {

        public int solution(String[][] clothes) {

            Map<String, Integer> cntMap = new HashMap<>();

            for (String[] clothe : clothes) {
                if (cntMap.containsKey(clothe[1])) {
                    cntMap.put(clothe[1], cntMap.get(clothe[1]) + 1);
                } else {
                    cntMap.put(clothe[1], 1);
                }
            }

            int answer = 1;
            for (int cnt : cntMap.values()) {
                answer *= (cnt + 1);
            }

            return answer - 1;
        }
    }
}