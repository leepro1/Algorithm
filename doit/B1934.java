/*
 * https://www.acmicpc.net/problem/1934
 * 최소공배수(gcd)
 * 유클리드 호제법을 이용한다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1934 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int result = 0;

			if (num1 > num2) {
				result = gcd(num1, num2);
			} else {
				result = gcd(num2, num1);
			}
			sb.append(num1 * num2 / result + "\n");
		}

		System.out.println(sb);
	}

	static int gcd(int bigNum, int smallNum) {
		if (smallNum == 0) {
			return bigNum;
		}
		return gcd(smallNum, bigNum % smallNum);
	}
}
