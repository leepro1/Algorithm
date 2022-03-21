package baekjoon;

import java.util.Scanner;

public class B1929 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int M=sc.nextInt();
		int N=sc.nextInt();
		
		StringBuilder sb =new StringBuilder();
		
		while(M<=N) {
			if(isPrime(M))
				sb.append(M+"\n");
			M++;
		}
		
		System.out.println(sb);
		
		sc.close();
	}
	
	public static boolean isPrime(int n) {
		if(n<2)
			return false;
		for(int i=2;i*i<=n;i++) {
			if(n%i==0)
				return false;
		}
		return true;
	}
}
