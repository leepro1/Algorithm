package sortAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellSort {
	public static void shellSort(int[] arr) {
		int i,j,item;
		for(int h=arr.length/2;h>0;h/=2) {
			for(i=h;i<arr.length;i++) {
				item=arr[i];
				for(j=i-h;j>=0 &&arr[j]>item;j-=h)
					arr[j+h]=arr[j];
				arr[j+h]=item;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		shellSort(arr);
	}
}
