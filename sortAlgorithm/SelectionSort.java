package sortAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {
	public static void selectionSort(int[] arr) {
		int min;
		for(int i=0;i<arr.length-1;i++) {
			min=i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[min])
					min=j;
			}
			swap(arr,i,min);
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
		selectionSort(arr);
		
		StringBuffer sb = new StringBuffer();

		for(int i=0;i<N;i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}