package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S7208 {
	static int n, count;
	static ArrayList<Integer>[] nationList;
	static int[] originColor;
	static int[] tempColor;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());

			// 색 입력받기
			originColor = new int[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				originColor[i] = Integer.parseInt(st.nextToken());
			}

			// 인접 나라 입력받기
			nationList = new ArrayList[n + 1];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				nationList[i] = new ArrayList<Integer>();

				for (int j = 1 ; j <= n; j++) {
					if (Integer.parseInt(st.nextToken()) == 1) {
						nationList[i].add(j);
					}
				}
			}

			// 색 입히고(중복 순열) 비교
			count = Integer.MAX_VALUE;
			tempColor = new int[n + 1];
			permutation(1, 0);

			sb.append("#" + t + " " + count + "\n");
		}

		System.out.println(sb);
	}

	public static void permutation(int depth, int tempCount) {
		if (depth - 1 == n) {
			if (checkColor()) {
				count = Math.min(count, tempCount);
			}
			return;
		}

		for (int i = 1; i <= 4; i++) {
			tempColor[depth] = i;
			permutation(depth + 1, tempCount + (i == originColor[depth] ? 0 : 1));
		}
	}

	public static boolean checkColor() {
		for (int i = 1; i < n; i++) {
			int nowColor = tempColor[i];

			for (int index : nationList[i]) {
				if (tempColor[index] == nowColor)
					return false;
			}
		}
		return true;
	}
}