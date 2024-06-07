pacakage programmers;

import java.util.*;

class P42747 {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int n = citations.length;
        int hIndex = 0;
        
        for(int i = 0; i < n; i++) {
            int h = n - i;
            if(citations[i] >= h) {
                hIndex = h;
                break;
            }
        }
        
        return hIndex;
    }
}
