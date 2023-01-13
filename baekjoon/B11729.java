//https://www.acmicpc.net/problem/11729
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11729 {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		sb.append((int)(Math.pow(2,N)-1)).append("\n");
		hanoi(N, 1, 2, 3);
		
		System.out.println(sb);
	}

	public static void hanoi(int n, int from, int temp, int to) {
		if (n == 1) {
			sb.append(from + " " + to).append("\n");
			return;
		}

		hanoi(n - 1, from, to, temp);
		sb.append(from + " " + to).append("\n");
		hanoi(n - 1, temp, from, to);
	}
}
