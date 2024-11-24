package programmers;

import java.util.*;

class P42883 {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (char digit : number.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() < digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder result = new StringBuilder();
        for (char digit : stack) {
            result.append(digit);
        }
        
        return result.toString();
    }
}
