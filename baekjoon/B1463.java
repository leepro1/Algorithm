package baekjoon;

import java.util.Scanner;

public class B1463 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		int N=sc.nextInt();		
		int cnt=0;
		
		while(N!=1) {
			if(N%3==0) {
				N/=3;
				cnt++;
			}
			
			else {
				N--;
				cnt++;
			}
		}
		
		System.out.println(cnt);
		sc.close();
	}
}
