package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " " + checkPalindrome(br.readLine()) + "\n");
		}
		System.out.println(sb);
	}

	public static int checkPalindrome(String str) {
		int start = 0;
		int end = str.length()-1;

		while (start < end) {
			if (str.charAt(start) == str.charAt(end)) {
				start++;
				end--;
			} else {
				return 0;
			}
		}

		return 1;
	}
}
