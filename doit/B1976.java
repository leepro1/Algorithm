/*
 * https://www.acmicpc.net/problem/1976
 * 여행 계획짜기
 * 어떤한 경로로든 연결되어있으면 갈 수 있으므로 같은 집합으로 취급한다.
 * 유니온 - 파인드 알고리즘을 사용하자.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 전체 도시 수
		int m = Integer.parseInt(br.readLine()); // 여행 도시 수

		parent = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= n; j++) {
				int linkCheck = Integer.parseInt(st.nextToken());
				if (linkCheck == 1)
					union(i, j);
			}
		}

		st = new StringTokenizer(br.readLine());
		int tempCityParent = Integer.parseInt(st.nextToken());
		boolean possibleFlag = true;

		while (m-- > 1) {
			if (find(tempCityParent) != find(Integer.parseInt(st.nextToken()))) {
				possibleFlag = false;
				break;
			}
		}

		if (possibleFlag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x <= y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}
}
