package baekjoon;

import java.util.Scanner;

public class B10250 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int H,W,N;
		int room;
		
		for(int i=0;i<T;i++) {
			H=sc.nextInt();
			W=sc.nextInt();
			N=sc.nextInt();
			room=(N%H)*100+(N/H+1);
			
			if(room<=100) 
				room=H*100+N/H;
			
			System.out.println(room);
		}
		sc.close();
	}
}
