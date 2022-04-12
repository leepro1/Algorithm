package baekjoon;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class B9095 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		int[] dp=new int[11]; //1부터 10까지
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		
		for(int i=4;i<11;i++) {
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		}
		while(T-->0) {
			int n=Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}
}
