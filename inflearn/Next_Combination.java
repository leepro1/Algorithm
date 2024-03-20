package inflearn;

import java.util.Arrays;

public class Next_Combination {

	public static int N; // 입력 데이터 수
	public static int R; // 뽑을 데이터 수
	public static int[] data; // 입력 데이터 배열
	public static int[] numbers; // 뽑은 데이터 배열

	public static void main(String[] args) {
		data = new int[] { 1, 2, 3, 4 };
		N = data.length;
		R = 2;
		numbers = new int[N];

		// 순열에서도 오른차순 정렬을 한 값을 첫 순열로 하듯 첫 조합을 만들자
		// 배열 뒤부터 R개수만큼 1로 만듦 : 4C2라면 0011 이런형태로
		int cnt = 0;
		while (++cnt <= R) {
			numbers[N - cnt] = 1;
		}

		do {
			for (int i = 0; i < N; i++) {
				if (numbers[i] == 1)
					System.out.print(data[i] + " ");
			}
			System.out.println();
		} while (np());
	}

	private static boolean np() {

		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			i--;

		if (i == 0)
			return false;

		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			j--;

		swap(i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}

		return true;
	}

	private static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}