package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2817 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int n, k, cnt;
		int start, end;
		int[] arr, cntArr;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n + 1];
			cntArr = new int[101];

			st = new StringTokenizer(br.readLine());
			int input;
			for (int i = 1; i <= n; i++) {
				input =Integer.parseInt(st.nextToken());
				if(cntArr[input]==0) {
					arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);

		/*	for (int i = 1; i <= n; i++) {
				sum[i] = sum[i - 1] + arr[i];
			}

			cnt = 0;
			start = 1;
			end = 2;
			while (true) {
				nowSum = sum[end] - sum[start - 1];
				System.out.println(nowSum);
				if (nowSum == k) {
					System.out.println(start+"더한다"+end);
					cnt++;
					start++;
					end++;
				} else if (nowSum < k) {
					end++;
				} else if (nowSum > k) {
					start++;
				}

				if (start > n || end > n) {
					break;
				}
*/			}

			sb.append("#" + t + " "  + "\n");
		}
		System.out.println(sb);
	}
}
