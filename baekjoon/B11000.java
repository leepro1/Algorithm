//https://www.acmicpc.net/problem/11000
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11000 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] lectureTime = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lectureTime[i][0] = Integer.parseInt(st.nextToken());
			lectureTime[i][1] = Integer.parseInt(st.nextToken());
		}

		// 람다식을 이용하여 정렬
		Arrays.sort(lectureTime, (o1, o2) -> {
			if (o1[1] == o2[1])
				return o1[0] - o2[0];
			return o1[1] - o2[1];
		});

		int last = 0; // 끝나는 시간
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			if (last <= lectureTime[i][0]) {
				last = lectureTime[i][1];
				cnt++;
			}
		}
		System.out.println(n - cnt + 1);
	}
}
