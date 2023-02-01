//https://www.acmicpc.net/problem/14501
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[] T=new int[N+1];
		int[] P=new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			T[i]=Integer.parseInt(st.nextToken());
			P[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			if(N<i+T[i]) //퇴사일을 넘겼을 때
				dp[i]=dp[i-1];
			else
				dp[i]=Math.max(dp[i-1],P[i]+dp[i+T[i]]);
		}
		
		System.out.println(dp[N]);
	}
}
