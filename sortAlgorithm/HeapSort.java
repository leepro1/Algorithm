package sortAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSort {
	public static void heapSort(int[] arr) {
		 int n = arr.length;

		 for (int i = n / 2 - 1; i >= 0; i--) {
			 heapify(arr, n, i);
		 }

		 for (int i = n - 1; i > 0; i--) {
			 swap(arr, 0, i);
			 heapify(arr, i, 0);
		}
	}
	public static void heapify(int[] arr, int n, int i) {
		int p = i;
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		if (l < n && arr[p] < arr[l])
			p = l;

		if (r < n && arr[p] < arr[r])
			p = r;

		if (i != p) {
			swap(arr, p, i);
			heapify(arr, n, p);
		}
	}
	
	public static void swap(int[] arr,int i,int j) {
		int temp=arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		heapSort(arr);
		
		StringBuffer sb = new StringBuffer();

		for(int i=0;i<N;i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}
