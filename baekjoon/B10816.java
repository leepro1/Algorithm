package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(st.nextToken());
		int arr[]=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<arr.length;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int M=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		while(M-->0) {
			int temp=Integer.parseInt(st.nextToken());
		}
		
	}
	public static int binarySearch(int[] arr, int target){ 
		int start=0; 
		int end=arr.length-1; 
		int mid=(end+start)/2; 

		while(end-start>= 0){ 
			if(arr[mid]>target) 
				end=mid-1;

			else if(arr[mid]<target){
				start= mid+1; 
			}
			else{
				return mid; 
			} 
			mid=(end+start)/2; 
		}
		return -1;
	}
}
