package baekjoon;

import java.util.Scanner;

public class B1003 {
	static int cntZero=0;
	static int cntOne=0;
	private static int fibonacci(int n) {
		if(n==0) {
			cntZero++;
			return 0;
		}
		if(n==1) {
			cntOne++;
			return 1;
		}
		return fibonacci(n-1)+fibonacci(n-2);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int i=0;i<T;i++) {
			int N=sc.nextInt();
			fibonacci(N);
			System.out.println(cntZero+" "+cntOne);
			cntZero=0;
			cntOne=0;
		}
		sc.close();
	}
}