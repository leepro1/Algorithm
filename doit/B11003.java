/*
 * https://www.acmicpc.net/problem/11003
 * 최소값 찾기
 * 슬라이딩 윈도우 알고리즘 방식으로 하나씩 밀어가며 최소값을 구하는데 중복인 수가 나왔다.
 * 중복 최소인 수의 index 체크하기위해서 이차원 배열을 선택하였다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11003 {
	static long[] numArr; 
	static long[][] minArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		numArr = new long[N];
		minArr = new long[N][2];
		for (int i = 0; i < N; i++) {
			numArr[i] = Long.parseLong(st.nextToken());
			if (i == 0) {
				minArr[0][0] = numArr[0];
				minArr[0][1] = 0;
			}
			else {
				findMin(i - L + 1, i);	
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(minArr[i] + " ");
		}
		System.out.println(sb);
	}

	static void findMin(int start, int end) {
		if(start<0) {
			start=0;
		}
	}
}
