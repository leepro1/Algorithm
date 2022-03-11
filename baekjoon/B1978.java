package baekjoon;

import java.util.Scanner;

public class B1978 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int num;
		int prime=0;
		int cnt=0;
		for(int i=0;i<N;i++) {
			num=sc.nextInt();
			for(int j=1;j<=num;j++) {
				if(num%j==0)
					cnt++;		
			}
			if(cnt==2)
				prime++;
			cnt=0;
		}
		System.out.println(prime);
		sc.close();
	}	
}
