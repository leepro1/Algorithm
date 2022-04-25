package baekjoon;
//중복인 수가 갈릴 수 있으니 중간 이분탐색 외 의 다른 방식 : 중복 원소의 길이
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
		
		st=new StringTokenizer(br.readLine());
		int M=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		while(M-->0) {
			int temp=Integer.parseInt(st.nextToken());
			sb.append(upperBound(arr, temp) - lowerBound(arr, temp)).append(" ");
		}
		System.out.println(sb);
	}
	public static int lowerBound(int[] arr, int target) {
		int low = 0; 
		int hi = arr.length; 
 
		while (low < hi) {
			int mid=(low + hi)/2;
 
			if (target <= arr[mid])
				hi=mid;
			
			else
				low=mid + 1;
		}

		return low;
	}
 
	public static int upperBound(int[] arr, int target) {
		int low = 0; 
		int hi = arr.length; 
 
		while (low < hi) {
			int mid=(low + hi)/2;

			if (target < arr[mid])
				hi=mid;
			
			else 
				low=mid + 1;
		}
		return low;
	}
}
