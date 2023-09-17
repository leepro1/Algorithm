/*
 * https://www.acmicpc.net/problem/1920
 * 수 찾기
 * 이진탐색을 재귀로 구현해 보자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920 {
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while (m-- > 0) {
			int target = Integer.parseInt(st.nextToken());
			if (binary_Search(target, 0, n - 1)) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
		}
		System.out.println(sb);
	}

	static boolean binary_Search(int target, int start, int end) {
		while (start <= end) {
			int mid = (start + end) / 2;
				
			if (arr[mid] == target) {
				return true;
			} else if (arr[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}	
		}
		return false;
	}
}
