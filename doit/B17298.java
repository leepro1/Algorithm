/*
 * https://www.acmicpc.net/problem/17298
 * 오큰수
 * 배열을 선언하여 오른쪽에 있는 값을 전부 검사를하면 O(n2)이라 시간초과일 것 같다.
 * Stack을 이용하는데 index를 넣는 스택을 만든다.
 * input값이 top값보다 크면 오큰수이다.
 * 
 * +)마지막에 스택이 빌 때까지 작업을 해주는것 잊지말자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] inputArr = new int[N];
		int[] answerArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inputArr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < N; i++) {
			if (inputArr[stack.peek()] < inputArr[i]) {
				while (!stack.empty() && inputArr[stack.peek()] < inputArr[i]) {
					answerArr[stack.pop()] = inputArr[i];
				}
			}
			stack.push(i);
		}

		while (!stack.empty()) {
			answerArr[stack.pop()] = -1;
		}

		for (int i = 0; i < N; i++) {
			sb.append(answerArr[i]).append(" ");
		}

		System.out.println(sb);
	}
}
