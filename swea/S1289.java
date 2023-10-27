package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1289 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int cnt;
		char nowValue;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			String str = br.readLine();
			cnt = 0;
			nowValue = '0';

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) != nowValue) {
					if (nowValue == '0')
						nowValue = '1';
					else if (nowValue == '1')
						nowValue = '0';
					cnt++;
				}
			}

			sb.append("#" + t + " " + cnt + "\n");
		}
		System.out.println(sb);
	}
}
