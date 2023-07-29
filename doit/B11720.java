/*
 * https://www.acmicpc.net/problem/11720
 * 숫자의 합
 * input이 최대 100자리수이므로 int나 long으로 받을 수 없다. -> String 또는 char[]
 * 문자는 더할 때 아스키코드로 더해지므로 -'0'을 해준다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11720 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += input.charAt(i) - '0';
		}

		System.out.println(sum);
	}
}
