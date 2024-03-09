package inflearn;

import java.util.Arrays;

public class Permutation {

	public static int N; // 입력 데이터 수
	public static int R; // 뽑을 데이터 수
	public static int[] data; // 입력 데이터 배열

	public static void main(String[] args) {
		data = new int[] { 1, 2, 3 };
		N = data.length;

		Arrays.sort(data);
		
		do {
			System.out.println(Arrays.toString(data));
		} while (np());
	}

	private static boolean np() {

		int i = N - 1;
		while (i > 0 && data[i - 1] >= data[i]) {
			i--;
		}

		if (i == 0)
			return false;

		int j = N - 1;
		while (data[i - 1] >= data[j]) {
			j--;
		}

		swap(i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}

		return true;
	}

	private static void swap(int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

}