/*
 * https://www.acmicpc.net/problem/1253
 * 좋은 수 구하기
 * 중첩반복문으로 풀면 시간이 초과되므로 투 포인터 사용
 * 중복값 처리로 알고리즘을 단순화 한다. -> 중복값 처리를 위한 배열이 OutOfMemoryError발생
 * 
 * 투 포인터 알고리즘을 이용한다.
 * 이때 비교 대상이 되는 값(numArr[result]는 result와 다른 두 수의 합이어야한다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1253 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] numArr = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			numArr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(numArr);

		int cnt = 0;
		for (int result = 0; result < N; result++) {
			int start = 0;
			int end = N - 1;

			while (start < end) {
				long sum = numArr[start] + numArr[end];
				
				if (sum == numArr[result]) {
					if (start != result && end != result) {
						cnt++;
						break;
					} else if (start == result) {
						start++;
					} else if (end == result) {
						end--;
					}
				} else if (sum > numArr[result]) {
					end--;
				} else {
					start++;
				}
			}
		}
		System.out.println(cnt);
	}
}
