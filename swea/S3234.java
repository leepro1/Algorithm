package swea;

//수행시간:885ms       메모리:23,112kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3234 {

	static int N, sum, cnt;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];

			sum = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}

			cnt = 0;
			Arrays.sort(arr);

			do {
				check(1, arr[0]);
			} while (np());

			sb.append("#" + test_case + " " + cnt + "\n");
		}

		System.out.println(sb);
	}

	public static boolean np() {
		// step1 : 교환위치 찾기
		int i = N - 1;
		while (i > 0 && arr[i - 1] >= arr[i])
			i--;

		// 마지막 순열
		if (i == 0) {
			return false;
		}

		// step 2 : 교환위치 찾기
		int j = N - 1;
		while (arr[i - 1] >= arr[j])
			j--;

		// step 3 : 교환하기
		swap(i - 1, j);

		// step4 : i부터는 오름차순 정렬
		int k = N - 1;
		while (i < k)
			swap(i++, k--);

		return true;
	}

	public static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void check(int depth, int tempSum) {
		if (depth == N) {
			cnt++;
			return;
		}
		if (tempSum < arr[depth]) {
			check(depth + 1, tempSum + arr[depth]);
		} else {
			check(depth + 1, tempSum + arr[depth]);
			check(depth + 1, tempSum - arr[depth]);
		}
	}
}
