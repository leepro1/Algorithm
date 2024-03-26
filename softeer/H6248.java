package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class H6248 {
	static int n, m, start, end;
	static boolean[] visited;
	static boolean[] check;
	static Set<Integer> answer = new HashSet<>();
	static ArrayList<Integer>[] nodeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		check = new boolean[n + 1];
		nodeList = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			nodeList[i] = new ArrayList<>();
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			nodeList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		dfs(start);
		for(int i=1;i<=n;i++){
            System.out.println(i+" "+check[i]);
        }
		visited = new boolean[n + 1];
		dfsCnt(end);

		System.out.println(answer.size() - 1);
	}

	static void dfs(int num) {
		for (int temp : nodeList[num]) {
			if (check[temp] || temp == end) {
				check[num] = true;
				continue;
			}
			if (!visited[temp]) {
				visited[temp] = true;
				dfs(temp);
				if (check[temp])
					check[num] = true;
			}
		}

	}

	static void dfsCnt(int num) {
		for (int temp : nodeList[num]) {
			if (!check[temp])
				continue;

			if (temp == start) {
				answer.add(num);
				continue;
			}
			if (check[temp]) {
				dfsCnt(temp);
				if (answer.contains(temp))
					answer.add(num);
			}
		}

	}
}
