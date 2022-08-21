//https://www.acmicpc.net/problem/9461
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9461 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		long[] dp=new long[101];
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;
		
		StringBuilder sb=new StringBuilder();
		while(T-->0) {
			int N=Integer.parseInt(br.readLine());
			
			for(int i=6;i<=N;i++) {
				dp[i]=dp[i-1]+dp[i-5];
			}
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
	}
}
