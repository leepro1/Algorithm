//평균값 구하기
package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2071 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int sum;
		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			double avg = (double) sum / 10;
			System.out.println("#" + i + " " + Math.round(avg));
		}
	}
}
