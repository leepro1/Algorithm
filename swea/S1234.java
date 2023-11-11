package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S1234 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;
		int n;
		String str;
		Character temp;
		LinkedList<Character> list;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			str = st.nextToken();

			list = new LinkedList<>();

			for (int i = 0; i < n; i++) {
				temp = str.charAt(i);

				if (list.isEmpty()) {
					list.add(temp);
					continue;
				}

				if (temp == list.getLast()) {
					list.removeLast();
				} else {
					list.add(temp);
				}
			}

			sb.append("#" + t + " ");
			for (char value : list) {
				sb.append(value);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}