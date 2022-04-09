package baekjoon;

import java.util.Scanner;

public class B2839 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int box=0;
		
		while(true) {
			if(N%5==0) {
				System.out.println(N/5+box);
				break;
			}
			else if(N<3) {
				System.out.println(-1);
				break;
			}
			N-=3;
			box++;
		}
		
		sc.close();
	}
}