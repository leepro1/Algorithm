package baekjoon;

import java.util.Scanner;

public class B2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			int R = sc.nextInt();
			String S = sc.next();
			String P = "";
			for(int j=0; j<S.length();j++){
				for(int k=0;k<R;k++) {
				P+=S.charAt(j);
				}
			}
			System.out.println(P);
		}
		sc.close();
	}
}
