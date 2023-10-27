package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2007 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int patternLength, checkIndex;
		char[] charArr;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			charArr = br.readLine().toCharArray();

			patternLength = -1;
			checkIndex = 0;
			for (int i = 1; i <= 20; i++) {
				if (charArr[i] == charArr[checkIndex]) {
					if (checkIndex == 0)
						patternLength = i - checkIndex;

					checkIndex++;
				} else {
					if (checkIndex == patternLength)
						break;

					patternLength = -1;
					checkIndex = 0;
				}
			}

			sb.append("#" + t + " " + patternLength + "\n");
		}
		System.out.println(sb);
	}
}
