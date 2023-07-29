/*
 * https://www.acmicpc.net/problem/1546
 * 평균
 * 입력을 받으며 maxScore를 구한다. 이 때 합을 구해두자
 * 각각 따로따로 새로운 점수를 구하지 말고
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] score = new int[N];
		int maxScore = 0;
		double sum = 0.0;
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			sum += score[i];
			if (score[i] > maxScore)
				maxScore = score[i];
		}

		System.out.println(sum / maxScore / N * 100);
	}
}
