package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class B2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        int tempValue = 1;
        int answer = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                tempValue *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                tempValue *= 3;
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }

                if (str.charAt(i - 1) == '(') {
                    answer += tempValue;
                }
                stack.pop();
                tempValue /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }

                if (str.charAt(i - 1) == '[') {
                    answer += tempValue;
                }
                stack.pop();
                tempValue /= 3;
            }
        }

        if (!stack.isEmpty()) {
            answer = 0;
        }

        System.out.println(answer);
    }
}
