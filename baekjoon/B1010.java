//https://www.acmicpc.net/problem/1010
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1010 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		int[][] dp = new int[31][31];

		for(int i=1;i<=30;i++) {
			dp[i][1]=i;
		}
		
		for(int i=2;i<=30;i++) {
			for(int j=2;j<=30;j++) {
				dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
			}
		}
		
		while(T-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			sb.append(dp[b][a]).append("\n");
		}
		
		System.out.println(sb);
	}
}
