/*
 * https://www.acmicpc.net/problem/2751
 * 수 정렬하기2
 * 병합정렬로 풀어보자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2751 {
	public static void mergeSort(int[] arr, int lb, int ub) {
		int middle;
		if (lb < ub) {
			middle = (lb + ub) / 2;
			mergeSort(arr, lb, middle);
			mergeSort(arr, middle + 1, ub);
			merge(arr, lb, middle, ub);
		}
	}

	public static void merge(int[] arr, int lb, int middle, int ub) {
		int[] tmp = arr.clone();

		int part1 = lb;
		int part2 = middle + 1;
		int index = lb;

		while (part1 <= middle && part2 <= ub) {
			if (tmp[part1] <= tmp[part2]) {
				arr[index++] = tmp[part1++];
			} else {
				arr[index++] = tmp[part2++];
			}
		}

		for (int i = 0; i <= middle - part1; i++) {
			arr[index + i] = tmp[part1 + i];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		mergeSort(arr, 0, N - 1);

		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < N; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}