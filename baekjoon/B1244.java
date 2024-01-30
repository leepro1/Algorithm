package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244 {
	static int n;
	static int[] switchStatus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		// 스위치 상태 설정
		switchStatus = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			if ("1".equals(st.nextToken()))
				switchStatus[i] = 1;
		}

		// test 수 입력
		int t = Integer.parseInt(br.readLine());

		int sex, inputNum;
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			sex = Integer.parseInt(st.nextToken());
			inputNum = Integer.parseInt(st.nextToken());

			changeSwitch(sex, inputNum);
		}

		// 출력부
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			sb.append(switchStatus[i] + " ");

			if (i % 20 == 0)
				sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void changeSwitch(int sex, int inputNum) {
		// 남자일 경우
		if (sex == 1) {
			for (int i = inputNum; i <= n; i += inputNum) {
				switchStatus[i] = switchStatus[i] == 1 ? 0 : 1;
			}
		}

		// 여자일 경우
		if (sex == 2) {
			int start = inputNum - 1;
			int end = inputNum + 1;
			switchStatus[inputNum] = switchStatus[inputNum] == 1 ? 0 : 1;

			while (true) {
				if (start < 1 || end > n)
					return;
				if (switchStatus[start] != switchStatus[end])
					return;

				switchStatus[start] = switchStatus[start] == 1 ? 0 : 1;
				switchStatus[end] = switchStatus[end] == 1 ? 0 : 1;

				start--;
				end++;
			}
		}
	}
}
