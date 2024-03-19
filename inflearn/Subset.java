package inflearn;

public class Subset {

	public static int N; // 입력 데이터 수
	public static int[] data; // 입력 데이터 배열

	public static void main(String[] args) {
		data = new int[] { 1, 2, 3 };
		N = data.length;

		subset(0, 0);
	}

	public static void subset(int depth, int bit) {
		if (depth == N) {
			for (int i = 0; i < N; i++) {
				if ((bit & 1 << i) != 0)
					System.out.print(data[i] + " ");
			}
			System.out.println();
			return;
		}

		subset(depth + 1, bit | 1 << depth);
		subset(depth + 1, bit);
	}
}
