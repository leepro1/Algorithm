//https://www.acmicpc.net/problem/10799
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B10799 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		Stack<Integer> stack = new Stack<>();

		int index = 1;
		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push(index);
			} else {
				if (index - stack.peek() == 1) {
					stack.pop();
					cnt += stack.size();
				} else {
					stack.pop();
					cnt += 1;
				}

			}

			index++;
		}
		System.out.println(cnt);
	}
}
