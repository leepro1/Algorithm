import java.util.*;

class P42885 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length - 1;
        int cnt = 0;
        
        while(start <= end) {
            if(start == end){
                cnt++;
                break;
            }
            
            if(limit >= people[start] + people[end]){
                start++;
                end--;
                cnt++;
            } else {
                end--;
                cnt++;
            }
        }
    
        return cnt;
    }
}
