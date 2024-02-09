package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1062 {
	static int n, k;
	static int answer = 0;
	static int staticBit = 0;
	static String[] stringArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		if (k >= 5) {
			staticBit |= 1 << 'a' - 'a';
			staticBit |= 1 << 'n' - 'a';
			staticBit |= 1 << 't' - 'a';
			staticBit |= 1 << 'i' - 'a';
			staticBit |= 1 << 'c' - 'a';

			stringArr = new String[n];

			for (int i = 0; i < n; i++) {
				stringArr[i] = br.readLine();

			}
			combination(0, 0, 0);
		}
		System.out.println(answer);
	}

	public static void combination(int depth, int start, int bitMask) {
		if (depth == k - 5) {
			answer = Math.max(answer, cntWord(bitMask + staticBit));
			return;
		}
		for (int i = start; i < 26; i++) {
			if ((staticBit & 1 << i) != 1) {
				combination(depth + 1, i + 1, bitMask | 1 << i);
			}
		}
	}

	public static int cntWord(int bitMask) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			boolean flag = false;
			for (int j = 4, size = stringArr[i].length(); j < size - 4; j++) {

				// 배울 수 없는 단어이면 flag가 true
				if ((bitMask & 1 << stringArr[i].charAt(j) - 'a') == 0) {
					flag = true;
					break;
				}
			}
			if (!flag)
				cnt++;
		}
		return cnt;
	}
}
