/*
 * https://www.acmicpc.net/problem/1043
 * 거짓말쟁이 지민이
 * 유니온-파인드를 이용하자
 * 진실을 아는 집합의 parent는 0으로 하여 union을 생략했다.
 * + 진실을 나중에 들키는 경우도 고려해주어야 하기 때문에 파티 정보를 저장해 두었다가 나중에 판별한다.
 * + 왜 그런지 모르겠는데 나중에 진실을 알게된 사람에 의한 거짓말을 들키는 파티는 1번만 반영이 아니라 연쇄적으로 dfs느낌으로 반영된다.
 */
package doit;

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
			boolean truthParty = false; // 진실된 파티 판별 변수
			partyPeopleList[i] = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			int peoples = Integer.parseInt(st.nextToken());

			while (peoples-- > 0) {
				int num = Integer.parseInt(st.nextToken());
				if (parent[num] == 0)
					truthParty = true;
				partyPeopleList[i].add(num);
			}

			// 진실을 알게된 파티였을때
			if (truthParty) {
				for (int temp : partyPeopleList[i])
					parent[temp] = 0;
			}
		}

		int cnt = 0; // 거짓파티의 수

		for (ArrayList<Integer> partyList : partyPeopleList) {
			cnt++;
			for (int num : partyList) {
				if (parent[num] == 0) {
					cnt--;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}
