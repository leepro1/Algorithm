//https://www.acmicpc.net/problem/1654
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int K=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		int[] arr=new int[K];
		
		long max=0;
		
		for(int i=0;i<K;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			if(arr[i]>max)
				max=arr[i];
		}
		
		System.out.println(upperBound(arr,max+1,N));
		
	}
	private static long upperBound(int[] arr,long max,int N) {
		long min = 0; 
		
		while (min < max) {
			long mid=(min + max)/2;
			long cnt=0;
			
			for(int i=0;i<arr.length;i++)
				cnt+=arr[i]/mid;
			
			if (cnt < N)
				max=mid;
			else 
				min=mid + 1;
		}
		return min-1;
	}
}
