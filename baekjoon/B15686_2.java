package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15686_2 {
	static int n, m;
	static int totalChicken = 0;
	static int answer = Integer.MAX_VALUE;
	static Node[] tempArr;
	static ArrayList<Node> arrayChicken = new ArrayList<>(); // 모든 치킨집의 좌표를 저장하는 배열
	static ArrayList<Node> arrayHome = new ArrayList<>(); // 모든 집의 좌표를 저장하는 배열
	
	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 입력부
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {

				switch (Integer.parseInt(st.nextToken())) {
				case 1:
					arrayHome.add(new Node(i, j));
					break;

				case 2:
					arrayChicken.add(new Node(i, j));
					totalChicken++;
					break;
				}
			}
		}

		tempArr = new Node[m];

		combination(0, 0);

		System.out.println(answer);
	}
	
	public static void combination(int depth, int start) {
		if (depth == m) {
			calDistance();
			return;
		}

		for (int i = start; i < totalChicken; i++) {
			tempArr[depth] = arrayChicken.get(i);
			combination(depth + 1, i + 1);
		}
	}

	public static void calDistance() {
		int sum = 0; // 도시의 치킨 거리

		for (int i = 0; i < arrayHome.size(); i++) {
			int tempSum = Integer.MAX_VALUE;

			for (int j = 0; j < m; j++) {
				int tempDistance = Math.abs(tempArr[j].r - arrayHome.get(i).r)
						+ Math.abs(tempArr[j].c - arrayHome.get(i).c);
				tempSum = Math.min(tempSum, tempDistance);

			}
			sum += tempSum;
		}

		answer = Math.min(sum, answer);
	}
}
