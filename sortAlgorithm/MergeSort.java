package sortAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
	public static void mergeSort(int[] arr, int lb, int ub) { 
		int middle;
		if(lb<ub) {
			middle=(lb+ub)/2;
			mergeSort(arr,lb,middle);
			mergeSort(arr,middle+1,ub);
			merge(arr,lb,middle,ub);
		}
	}
	
	public static void merge(int[] arr, int lb, int middle, int ub) {
		//정렬 한 뒤 병합하는 함수
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
		mergeSort(arr,0,N-1);
	}
}
