package baekjoon;

import java.util.Scanner;
import java.util.Arrays;

public class B2108 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		int[] arr=new int[N];
		
		for(int i=0;i<N;i++) 
			arr[i]=sc.nextInt();
		
		Arrays.sort(arr);
		
		System.out.println(mean(arr));
		System.out.println(midian(arr));
		//System.out.println(mode(arr));
		System.out.println(diff(arr));
		
		sc.close();
	}
	
	private static int mean(int[] arr) {
		float sum=0;
		
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		
		return Math.round(sum/arr.length);
	}
	
	private static int midian(int arr[]) {
		return arr[(arr.length-1)/2];
	}
	
	/*	
	private static int mode(int arr[]) {
		int[][] cnt=new int[arr.length][2];
		cnt[0][0]=arr[0];
		cnt[0][1]=1;
		int mode=0;
		
		for(int i=1;i<arr.length-1;i++) {
			cnt[i][0]=arr[i];
			cnt[i][1]=1;
			if(arr[i]==arr[i+1]) {
				cnt[i][1]++;
			}
		}
		
		for(int i=0;i<arr.length-1;i++) {
			if(cnt[i][1]>cnt[i+1][1])
				mode=cnt[i][0];
			else if(cnt[i][1]==cnt[i+1][1])
				mode=(cnt[i][1]>cnt[i+1][1]?cnt[i+1][1]:cnt[i][1]);
		}
	
		return mode;
	}
*/	
	private static int diff(int arr[]) {
		return arr[arr.length-1]-arr[0];
	}
}
