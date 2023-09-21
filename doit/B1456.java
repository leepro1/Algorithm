/*
 * https://www.acmicpc.net/problem/1456
 * 거의 소수
 * 소수의 N제곱 꼴인 값을 거의 소수라고 한다.
 * 소수를 먼저 구하고 범위 내에서 N제곱을 구하자. 
 * 웬만큼 크면 long 자료형을 사용하자 
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1456 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		boolean[] checkArr = new boolean[(int) Math.sqrt(b) + 1];

		for (int i = 2; i * i <= checkArr.length; i++) {
			if (checkArr[i])
				continue;
			for (int j = i * 2; j < checkArr.length; j += i) {
				checkArr[j] = true;
			}
		}
		
		int cnt = 0;
		for (int i = 2; i < checkArr.length; i++) {
			if (checkArr[i]) {
				continue;
			}
			for (int j = 2; Math.pow(i, j) <= b; j++) {
				if (Math.pow(i, j) >= a)
					cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
