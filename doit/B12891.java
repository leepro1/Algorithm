/*
 * https://www.acmicpc.net/problem/12891
 * DNA 비밀번호
 * 슬라이딩 윈도우 알고리즘 느낌으로 한칸씩 밀어가면서 check를 하였다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891 {
	static int[] checkArr = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이

		String input = br.readLine();

		// 암호 규칙 입력부분
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		for (int i = 0; i < S; i++) {
			// 현재 범위 index 체크
			int index = cntIndex(input.charAt(i));
			if (index >= 0) {
				checkArr[index]--;
			}

			// 범위를 지나간 index 체크
			if (i >= P) {
				index = cntIndex(input.charAt(i - P)); // 지난 DNA;
				if (index >= 0) {
					checkArr[index]++;
				}
			}

			// 정답인지 count
			if (i >= P - 1 && checkDNA()) {
				cnt++;
			}

		}
		System.out.println(cnt);
	}

	// 규칙에 맞는지 확인하기위한 함수
	static int cntIndex(char temp) {
		switch (temp) {
		case 'A':
			return 0;
		case 'C':
			return 1;
		case 'G':
			return 2;
		case 'T':
			return 3;
		default:
			return -1;
		}
	}

	static boolean checkDNA() {
		if (checkArr[0] > 0 || checkArr[1] > 0 || checkArr[2] > 0 || checkArr[3] > 0)
			return false;
		else
			return true;
	}
}
