package programmers;

import java.util.*;

class P42576 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for(String part : participant) {
            if(map.containsKey(part))
                map.put(part, map.get(part) + 1);
            else
                map.put(part, 1);
        }
        
        for(String com : completion){
            map.put(com, map.get(com) - 1);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0)
                return entry.getKey();
        }
        return  "";
    }
}
