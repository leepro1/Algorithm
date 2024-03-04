package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B1043 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 사람의 수
		int m = Integer.parseInt(st.nextToken()); // 파티의 수

		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		// 진실을 아는 사람의 parent 갱신
		st = new StringTokenizer(br.readLine());
		int truthPeopleNum = Integer.parseInt(st.nextToken());
		while (truthPeopleNum-- > 0) {
			parent[Integer.parseInt(st.nextToken())] = 0;
		}

		// 파티당 참석자 list
		ArrayList<Integer>[] partyPeopleList = new ArrayList[m];

		for (int i = 0; i < m; i++) {
			partyPeopleList[i] = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			int peoples = Integer.parseInt(st.nextToken());

			while (peoples-- > 0)
				partyPeopleList[i].add(Integer.parseInt(st.nextToken()));

			for (int temp = 1, size = partyPeopleList[i].size(); temp < size; temp++)
				union(partyPeopleList[i].get(temp - 1), partyPeopleList[i].get(temp));
		}

		int cnt = 0; // 거짓파티의 수

		for (ArrayList<Integer> partyList : partyPeopleList) {
			cnt++;
			for (int num : partyList) {
				if (find(num) == 0) {
					cnt--;
					break;
				}
			}
		}
		System.out.println(cnt);
	}

	static int find(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}
}
