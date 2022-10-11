//https://www.acmicpc.net/problem/5430
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class B5430 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>(); // 함수 수행을 위한 덱
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			String func = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String numArrInput = br.readLine();
			String[] numArr = numArrInput.substring(1, numArrInput.length() - 1).split(",");

			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(numArr[i]));
			}

			Boolean reverseFlag = false; // 뒤에서부터 진행될 때 true
			String str = "";

			for (int i = 0; i < func.length(); i++) {
				if (func.charAt(i) == 'R') { // R일때
					if (reverseFlag)
						reverseFlag = false;
					else
						reverseFlag = true;
				} else { // D일때
					if (deque.isEmpty()) {
						str = "error"; // StringBuilder 비우기 : sb.setLength(0)
						break;
					}

					if (reverseFlag) {
						deque.pollLast();
					} else {
						deque.poll();
					}
				}
			}

			if (!str.equals("error")) {
				sb.append("[");
				while (!deque.isEmpty()) {
					sb.append(reverseFlag ? deque.pollLast() : deque.poll());
					if (deque.size() != 0)
						sb.append(',');
				}
				sb.append("]\n");
				deque.clear();
			}
			else
				sb.append(str+"\n");
		}
		System.out.println(sb);
	}
}
