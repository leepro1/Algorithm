package baekjoon;

//수행시간:ms       메모리:kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 0) {
			System.out.println(0);
			System.exit(0);
		}

		int x, y;
		int[][] visited = new int[100][2];
		StringTokenizer st;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			for (int i = 0; i < 10; i++) {
			}
		}
		int answer = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (visited[i][j])
					answer++;
			}
		}

		System.out.println(answer);
	}
}
