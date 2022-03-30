package baekjoon;

import java.util.Scanner;

public class B1065 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int cnt=0;
		
		if(N<100)
			cnt=N;
		
		else {
			cnt=99;
			if(N==1000)
				N--;
			
			for(int i=100;i<=N;i++) {
				if(i/100 - (i%100)/10 == (i%100)/10 -i%10)
					cnt++;
			}	
		}

		System.out.println(cnt);
		sc.close();
	}
}
