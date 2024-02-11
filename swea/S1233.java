package swea;

//수행시간:135ms       메모리:19,424kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1233 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, answer;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());

			answer = 1;
			while (N-- > 0) {
				st = new StringTokenizer(br.readLine());
				if (st.countTokens() == 2) {
					st.nextToken();
					if (st.nextToken().charAt(0) < 48) {
						answer = 0;
					}
				} else if (st.countTokens() == 3) {
					answer = 0;
				} else {
					st.nextToken();
					if (st.nextToken().charAt(0) >= 48)
						answer = 0;
				}
			}

			sb.append("#" + t + " " + answer + "\n");
		}

		System.out.println(sb);
	}
}
