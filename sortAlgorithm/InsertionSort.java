package sortAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort {
	public static void insertionSort(int[] arr) {
		int i,j,item;
		for(i=1;i<arr.length;i++) {
			item=arr[i];
			for(j=i;j>0 && arr[j-1]>item;j--)
				arr[j]=arr[j-1];
			arr[j]=item;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		insertionSort(arr);
	}
}
