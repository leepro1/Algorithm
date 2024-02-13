package baekjoon;

//수행시간:120ms       메모리:14,228kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int box = 0;

		while (true) {
			if (N != 0 && N < 3) {
				System.out.println(-1);
				break;
			} else if (N % 5 == 0) {
				System.out.println(N / 5 + box);
				break;
			}
			N -= 3;
			box++;
		}

	}
}