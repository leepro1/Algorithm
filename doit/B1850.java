/*
 * https://www.acmicpc.net/problem/1850
 * 최대공약수 구하기
 * 입력받은 값의 최대공약수를 구하고 그것을 1로 표현한다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1850 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long num1 = Long.parseLong(st.nextToken());
		long num2 = Long.parseLong(st.nextToken());

		long result = 0;
		if (num1 > num2)
			result = gcd(num1, num2);
		else
			result = gcd(num2, num1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result; i++) {
			sb.append(1);
		}
		System.out.println(sb);
	}

	static long gcd(long bigNum, long smallNum) {
		if (smallNum == 0)
			return bigNum;
		return gcd(smallNum, bigNum % smallNum);
	}
}
