//홀수만 더하기
package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2072 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long sum;
		StringTokenizer st;
		for (int j = 1; j <= n; j++) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 10; i++) {
				int tempNum = Integer.parseInt(st.nextToken());
				if (tempNum % 2 == 1)
					sum += tempNum;
			}
			System.out.println("#" + j + " " + sum);
		}
	}
}
