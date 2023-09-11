/*
 * https://www.acmicpc.net/problem/11399
 * ATM기 인출시간 구하기
 * 삽입정렬로 풀어보자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11399 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		insertionSort();

		int sum = 0;
		int eachTime = 0;

		for (int i = 0; i < n; i++) {
			sum += eachTime + arr[i];
			eachTime += arr[i];
		}

		System.out.println(sum);
	}

	static void insertionSort() {
		int i, j, item;

		for (i = 1; i < arr.length; i++) {
			item = arr[i];
			for (j = i; j > 0 && arr[j - 1] > item; j--)
				arr[j] = arr[j - 1];
			arr[j] = item;
		}
	}
}
