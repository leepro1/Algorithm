package baekjoon;

// 수행시간:696ms       메모리:14636KB
// idea : 가장 앞자리 수는 2,3,5,7 그리고 그 이후는 1,3,7,9 만 이어 붙일 수 있다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2023 {
	static StringBuilder sb = new StringBuilder();
	static int[] plusNumList = { 1, 3, 7, 9 };
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		findAnswer(2, 1);
		findAnswer(3, 1);
		findAnswer(5, 1);
		findAnswer(7, 1);

		System.out.println(sb);
	}

	public static void findAnswer(int num, int digitCnt) {
		if (digitCnt == n && isPrime(num)) {
			sb.append(num + "\n");
			return;
		}

		for (int plusNum : plusNumList) {
			if (isPrime(num)) {
				findAnswer(num * 10 + plusNum, digitCnt + 1);
			}
		}
	}

	public static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
