package baekjoon;
//큐배우면 다시 풀기

import java.util.Scanner;
import java.util.ArrayList;


public class B11866 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		sb.append("<");
		
		
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		int[] arr=new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=i+1;
		}
		
		int temp=K;
		for(int i=0;i<N;i++) {
			sb.append(Integer.toString(arr[temp-1]));
			arr[temp-1]=0;
			
			temp+=K;
			
			if(temp>N)
				temp=temp%N;
			
			while(arr[temp-1]==0) {
				temp++;
				if(temp>N)
					temp=1;
			}
			System.out.println(sb);	
		}
		sb.append(">");
		
		
		sc.close();
	}
}
