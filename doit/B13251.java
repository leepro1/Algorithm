/*
 * https://www.acmicpc.net/problem/13251
 * 조약동 꺼내기
 * 조합배열을 구현하는 것이 아닌 컬러별로 확률을 구한다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine()); // 색상의 개수

		int[] numByColor = new int[m];
		int totalCount = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			numByColor[i] = Integer.parseInt(st.nextToken());
			totalCount += numByColor[i];
		}

		int k = Integer.parseInt(br.readLine()); // 뽑은 개수

		double sum = 0;
		for (int i = 0; i < m; i++) {
			if (numByColor[i] < k)
				continue;

			double probability = 1.0;
			for (int j = 0; j < k; j++) {
				probability *= (double) (numByColor[i] - j) / (totalCount - j);
			}
			sum += probability;
		}
		System.out.println(sum);
	}
}
