package programmers;

import java.util.*;

class P12909 {
    boolean solution(String s) {
        boolean answer = true;

        ArrayDeque<Character> stack = new ArrayDeque<>(); 
        for(int i=0, size = s.length(); i<size; i++){
            char now = s.charAt(i);
            
            if(now=='('){
                stack.push(now);    
            } else {
                if(stack.isEmpty())
                    return false;
                
                if(stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(now);    
                }
                
            }
            
        }
        
        if(!stack.isEmpty())
            return false;

        return answer;
    }
}