/*
 * https://www.acmicpc.net/problem/10986
 * 나머지 합
 * 나누어 떨어지는 값은 구해야하므로 나머지 합배열을 구하자
 * 나머지 합배열이 0인것은 당연히 count한다. 이것은 index가 1부터이므로 다른 구간도 찾아야한다.
 * 다른 구간 찾는법은 나머지 합이 같은 2개의 index(구간시작과 끝)를 찾는 것이다. 그 구간의 나머지 합을 다시 구하면 0이니까...
 * 중첩 반복문은 시간을 초과한다. 따라서 나머지로 나오는 값의 배열을 따로 구하고 조합(Combination)을 이용하자. 
 * long 타입으로 바꾸어 주자. 웬만하면 int형보단 long형쓰자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] remainderSumArr = new long[N + 1]; // 나머지 합배열
		long[] remainderIndexArr = new long[M]; // 조합계산을 위한 같은 나머지값(index) 배열 -> 2개를 뽑을 것이다.
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			remainderSumArr[i] = (Integer.parseInt(st.nextToken()) + remainderSumArr[i - 1]) % M;
			remainderIndexArr[(int) remainderSumArr[i]]++;
		}

		long cnt = 0;
		cnt += remainderIndexArr[0];

		for (int i = 0; i < M; i++) {
			long temp = remainderIndexArr[i]; // 나머지가 i인 개수
			
			// temp C(combination) 2의 값을 구한다.
			if (temp >= 2) {
				cnt += temp * (temp - 1) / 2;
			}
		}

		System.out.println(cnt);
	}
}
