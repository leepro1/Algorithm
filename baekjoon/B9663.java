/*
 * https://www.acmicpc.net/problem/9663
 * N-Queen
 * 백트래킹 문제, 대각선을 검사하는 방식을 잘 익혀두어야 함
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663 {
	static int n, cnt = 0;
	static int[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n];

		dfs(0);

		System.out.println(cnt);
	}

	static void dfs(int depth) {
		if (n == depth) {
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) {
			map[depth] = i;
			
			if (checkMap(depth)) {
				dfs(depth + 1);
			}
		}
	}

	static boolean checkMap(int depth) {
		for (int i = 0; i < depth; i++) {
			if (map[i] == map[depth])
				return false;

			if (map[i] - i == map[depth] - depth)
				return false;

			if (map[i] + i == map[depth] + depth)
				return false;
		}

		return true;
	}
}
