/*
 * https://www.acmicpc.net/problem/11004
 * K번째 수
 * 퀵정렬로 풀어보자 -> 시간초과가 난다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11004 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		quickSort(0, n - 1);

		System.out.println(arr[k - 1]);
	}

	public static void quickSort(int start, int end) {
		if (start < end) {
			int p = partition(start, end); // 분할
			quickSort(start, p - 1); // 왼쪽 분할 퀵 정렬
			quickSort(p + 1, end); // 오른쪽 분할 퀵 정렬
		}
	}

	public static int partition(int start, int end) {
		int pivot = start; // 기준값을 맨 앞 원소로 설정
		int i = start;
		int j = end;

		while (i < j) {

			while (arr[i] < arr[pivot] && i < j) {
				i++;
			}
			while (arr[j] > arr[pivot] && i < j) {
				j--;
			}
			swap(i, j);

		}
		swap(start, j);
		
		return j;
	}

	public static void swap(int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
