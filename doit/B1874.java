/*
 * https://www.acmicpc.net/problem/1874
 * 스택 수열
 * 스택을 이용하여 주어진 수열을 만들자.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		int num = 1;

		while (n-- > 0) {
			int input = Integer.parseInt(br.readLine());

			if(input >= num) {
				while (input >= num) {
					stack.push(num++);
					sb.append("+\n");
				}
			}

			else if (stack.peek() != input) {
				System.out.println("NO");
				sb.setLength(0);
				break;
			}
			
			stack.pop();
			sb.append("-\n");
		}

		System.out.println(sb);
	}
}
