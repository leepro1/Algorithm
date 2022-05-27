//https://www.acmicpc.net/problem/2750
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_1 {
	public static void quickSort(int[] arr, int begin, int end) { //재귀 알고리즘
		if(begin<end) {
			int p=partition(arr,begin,end); //분할
			quickSort(arr,begin,p-1); //왼쪽 분할 퀵 정렬
			quickSort(arr,p+1,end); //오른쪽 분할 퀵 정렬
		}
	}
	
	public static int partition(int[] arr, int begin, int end) {
		int pivot =arr[begin]; //기준값을 맨 앞 원소로 설정
		int i=begin;
		int j=end+1;
		
		do {
			do {i++;}while(i<=end && arr[i]<pivot);
			do {j--;}while(arr[j]>pivot);
			if(i<j)
				swap(arr,i,j);
		}while(i<j);
		
		swap(arr,begin,j);
		return j;
	}
	
	public static void swap(int[] arr,int i,int j) { //위치를 바꾸는 함수
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
		quickSort(arr,0,N-1);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}
