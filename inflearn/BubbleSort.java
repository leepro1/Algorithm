package inflearn;

import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		sc.close();
		
		for(int i=n-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
		
	}
}
