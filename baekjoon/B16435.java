package baekjoon;

//수행시간:128ms       메모리:14,380kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16435 {
	static int N, L;
	static int[] fruits;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		fruits = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(fruits);

		for (int i = 0; i < N; i++) {
			if (fruits[i] <= L)
				L++;
			else
				break;
		}
		
		System.out.println(L);
	}
}
