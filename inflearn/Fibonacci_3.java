package inflearn;
/*
반복문으로 구현 - 바텀업방식
O(N)시간
*/
import java.util.Scanner;

public class Fibonacci_3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] dp=new int[N+1];
		dp[0]=0;
		dp[1]=1;
		
		for(int i=2;i<=N;i++)
			dp[i]=dp[i-1]+dp[i-2];
		
		System.out.println(dp[N]);
		sc.close();
	}
}
