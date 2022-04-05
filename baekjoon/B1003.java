package baekjoon;

import java.util.Scanner;

public class B1003 {
	static int[][] cnt=new int[41][2];
	
	private static int[] fibonacci(int n) {
		if(n==0) {
			cnt[0][0]=1;
			cnt[0][1]=0;
			return cnt[0];
		}
		if(n==1) {
			cnt[1][0]=0;
			cnt[1][1]=1;
			return cnt[1];
		}
		if(cnt[n][0]!=0||cnt[n][1]!=0) {
			return cnt[n];
		}
		cnt[n][0]+=fibonacci(n-1)[0]+fibonacci(n-2)[0];
		cnt[n][1]+=fibonacci(n-1)[1]+fibonacci(n-2)[1];
		return cnt[n];
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
	
		for(int i=0;i<T;i++) {
			int N=sc.nextInt();
			fibonacci(N);
			System.out.println(cnt[N][0]+" "+cnt[N][1]);
		}
		sc.close();
	}
}