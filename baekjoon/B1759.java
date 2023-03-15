//https://www.acmicpc.net/problem/1759
/*
 * 암호 만들기 - 백트래킹
 * 암호의 조건 - L개의 알파벳 소문자, 최소 한개의 모음+두개의 자음, 오름차순
 * 문자들을 정렬 한 후 조건에 맞게 백트래킹 하면 된다.
 * check변수를 통해 모음,자음 조건을 처리하도록 해보자
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1759 {
	private static int L, C;
	private static char[] password, tempPassword;
	private static boolean[] visited;
	private static int[] check = new int[2]; // 모음, 자음의 조건이 맞는지 확인할 배열
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		password = new char[C];
		tempPassword = new char[L];
		visited = new boolean[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			password[i] = st.nextToken().charAt(0);
		}

		// 오름차순 정렬
		Arrays.sort(password);

		dfs(0, 0);
		System.out.println(sb);
	}

	private static void dfs(int start, int depth) {
		if (depth == L) {
			if (1<=check[0]&&check[1]>=2) {
				for (char c : tempPassword) {
					sb.append(c);
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = start; i < C; i++) {
			if (!visited[i]) {
				visited[i] = true;
				tempPassword[depth] = password[i];
				
				if (password[i] == 'a' || password[i] == 'e' || password[i] == 'i' || password[i] == 'o' || password[i] == 'u') {
					check[0]++;
					dfs(i + 1, depth + 1);
					check[0]--;
				}
				else {
					check[1]++;
					dfs(i + 1, depth + 1);
					check[1]--;
				}
				visited[i] = false;
			}
		}
	}
}
