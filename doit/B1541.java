/*
 * https://www.acmicpc.net/problem/1541
 * 잃어버린 괄호
 * 그리디로 -연산에 주의하여(최소만들기 위한 괄호 넣기) 푼다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		boolean minusFlag = false; // -연산중일때는 true
		int sum = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '-' && str.charAt(i) != '+') {
				sb.append(str.charAt(i));
			}
			if (i + 1 == str.length() || str.charAt(i) == '-' || str.charAt(i) == '+') {
				if (minusFlag) {
					sum -= Integer.parseInt(sb.toString());
				} else {
					sum += Integer.parseInt(sb.toString());
				}
				sb.setLength(0);
			}
			if (str.charAt(i) == '-') {
				minusFlag = true;
			}
		}
		System.out.println(sum);
	}
}
