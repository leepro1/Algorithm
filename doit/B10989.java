/*
 * https://www.acmicpc.net/problem/10989
 * 수 정렬하기3
 * 기수정렬로 풀어보자 -> 시간 초과가 난다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer> negativeArr = new ArrayList<>();
		ArrayList<Integer> positiveArr = new ArrayList<>();

		int max = 0;
		int min = 0;
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if (input >= 0) {
				positiveArr.add(input);
				if (input > max) {
					max = input;
				}
			} else {
				negativeArr.add(-input);
				if (input < min) {
					min = input;
				}
			}
		}
		
		negativeArr = radixSort(negativeArr, -min);
		positiveArr = radixSort(positiveArr, max);


		while (!negativeArr.isEmpty()) {
			System.out.println(-negativeArr.remove(negativeArr.size()-1));
		}
		for (int i : positiveArr) {
			System.out.println(i);
		}
	}

	public static ArrayList<Integer> radixSort(ArrayList<Integer> arr, int lastNum) {

		if(arr.isEmpty()) { 
			return arr;
		}
		Queue<Integer>[] bucket = new LinkedList[10];
		for (int i = 0; i < 10; i++) {
			bucket[i] = new LinkedList<Integer>();
		}

		for (int digit = 1; digit <= lastNum; digit *= 10) {
			while(!arr.isEmpty()) {
				int temp = arr.remove(0);
				bucket[(temp / digit) % 10].add(temp);
			}

			for (int i = 0, j = 0; i < 10; i++) {
				while (!bucket[i].isEmpty()) {
					arr.add(bucket[i].poll());
				}
			}
		}

		return arr;
	}
}
