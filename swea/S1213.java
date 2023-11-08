package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t, cnt, nowIndex;
		String inputStr, findStr;

		StringBuilder sb = new StringBuilder();
		while (true) {
			t = Integer.parseInt(br.readLine());
			findStr = br.readLine();
			inputStr = br.readLine();

			cnt = -1;
			nowIndex = 0;
			while (nowIndex != -1) {
				cnt++;
				nowIndex = inputStr.indexOf(findStr, nowIndex + 1);
			}

			sb.append("#" + t + " " + cnt + "\n");

			if (t == 10)
				break;
		}
		System.out.println(sb);
	}
}
