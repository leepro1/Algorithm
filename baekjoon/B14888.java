//https://www.acmicpc.net/problem/14888
/*
 * 연산자 끼워넣기 - 백트래킹
 * dfs로 백트래킹을 해줄때 모든 경우의 수를 고려하는 방법을 사용하자 -> switch로 반복하여 풀자
 * depth==n일때 즉 n-1번의 연산이 끝났을 때마다 min,max를 갱신해주자
 * 연산자배열은 마치 visited를 복구한 것처럼 복구하자
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888 {
	static int n;
	static int[] num, operator;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		num = new int[n];
		operator = new int[4];

		// n개의 수 입력받기
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		// 연사자의 수 입력받기 (+, -, *, /)
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		// dfs로 백트래킹
		dfs(num[0], 1);

		System.out.println(max + "\n" + min);
	}

	private static void dfs(int result, int depth) {
		// 한줄의 연산을 마무리하면
		if (depth == n) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		// 모든 경우의 수
		for (int i = 0; i < 4; i++) {
			if (operator[i] == 0)
				continue;

			operator[i]--;

			switch (i) {
			case 0:
				dfs(result + num[depth], depth + 1);
				break;
			case 1:
				dfs(result - num[depth], depth + 1);
				break;
			case 2:
				dfs(result * num[depth], depth + 1);
				break;
			case 3:
				dfs(result / num[depth], depth + 1);
				break;
			}

			// 한줄의 연산이 끝나면 연산자 배열을 복구한다.
			operator[i]++;
		}
	}

}
