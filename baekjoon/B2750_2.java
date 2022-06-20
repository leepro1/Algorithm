//https://www.acmicpc.net/source/44084198
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2750_2 {
	public static void bubbleSort(int[] arr,int n) {
		for(int i=n-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[j+1])
					swap(arr,j,j+1);
			}
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
		bubbleSort(arr,N);

		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.println(sb);
	}
}