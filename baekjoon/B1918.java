//https://www.acmicpc.net/problem/1918
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1918 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str =br.readLine();

		Stack<Character> stack = new Stack<>();
		StringBuilder resultSb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char symbol = str.charAt(i);
			
			//피연산자는 출력
			if ('A' <= symbol && symbol <= 'Z') {
				resultSb.append(symbol);
			}

			//(가 나올때까지 pop
			else if (symbol == ')') {
				while(!stack.isEmpty()) {
					if(stack.peek()=='('){
						stack.pop();
						break;
					}
					resultSb.append(stack.pop());	
				}
			} 
			
			//)가 아닌 심볼일때는 연산자 우선순위 고려
			else {
				while(!stack.isEmpty() && ISP(stack.peek())>=ICP(symbol)) {
					resultSb.append(stack.pop());
				}
				stack.push(symbol);
			}
		}
		
		while (!stack.isEmpty())
			resultSb.append(stack.pop());

		System.out.println(resultSb);
	}

	private static int ISP(char x) {
		if(x=='(')
			return 0;
		
		else if(x=='+' || x=='-')
			return 1;
		
		else
			return 2;
	}
	
	private static int ICP(char x) {
		if(x=='(')
			return 4;
		
		else if(x=='+' || x=='-')
			return 1;
		
		else
			return 2;
	}
}
