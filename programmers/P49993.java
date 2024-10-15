package programmers;

import java.util.*;

class P49993 {
    
    static Map<Character, Integer> map;
    
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        map = new HashMap<>();
            
        for(int i = 0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }
    
        for(String str : skill_trees) {
            if(check(str)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static boolean check(String str) {
        int now = 0;
        
        for(int i = 0; i < str.length(); i++) {
            
            if(!map.containsKey(str.charAt(i)))
               continue;
            
            if(now == map.get(str.charAt(i))) {
               now++;
            } else {
                return false;
            }
            
        }
        
        return true;
    }
}
