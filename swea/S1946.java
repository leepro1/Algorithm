package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1946 {
	static int cnt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int n, alphabetCnt;
		char alphabet;

		StringTokenizer st;
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			cnt = 0;

			sb.append("#" + test_case + "\n");

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				alphabet = st.nextToken().charAt(0);
				alphabetCnt = Integer.parseInt(st.nextToken());

				unzip(alphabet, alphabetCnt);
			}

			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void unzip(char alphabet, int alphabetCnt) {
		for (int i = 0; i < alphabetCnt; i++) {
			if (cnt == 10) {
				sb.append("\n");
				cnt = 0;
			}
			sb.append(alphabet);
			cnt++;
		}
	}
}
