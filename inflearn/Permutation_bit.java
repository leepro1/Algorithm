import java.util.*;
import java.io.*;

public class Permutation_bit {

	public static int N; // 입력 데이터 수
	public static int R; // 뽑을 데이터 수
	public static int[] data; // 입력 데이터 배열
	public static int[] numbers; // 뽑은 데이터 배열

	public static void main(String[] args) {
		data = new int[] { 1, 2, 3 };
		N = data.length;
		R = 3;
		numbers = new int[R];

		permutation(0, 0);
	}

	public static void permutation(int depth, int bit) {
		if (depth == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		for (int i = 0; i < N; i++) {
			if ((bit & 1 << i) != 0)
				continue;

			numbers[depth] = data[i];
			permutation(depth + 1, bit | 1 << i);
		}
	}
}