package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H6247 {
	static int n;
	static int[] fuel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		fuel = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			fuel[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(fuel);

		StringBuilder sb = new StringBuilder();
		while (q-- > 0) {
			sb.append(binarySearch(Integer.parseInt(br.readLine()))).append("\n");
		}
		System.out.println(sb);
	}

	static int binarySearch(int m) {
		int start = 0;
		int end = n - 1;
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;
			
			if (fuel[mid] == m) {
				return (n - 1 - mid) * mid;
			} else if (fuel[mid] < m) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		
		return 0;
	}
}
