/*
 * https://www.acmicpc.net/problem/1427
 * 소트인사이드
 * 선택정렬로 풀어보자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();

		int[] arr = new int[n.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Character.getNumericValue(n.charAt(i));
		}

		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = i; j < arr.length ; j++) {
				if (arr[j] > max) {
					max = arr[j];
					index = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}
}
