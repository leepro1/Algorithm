package baekjoon;

import java.util.Scanner;

public class B3046 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R1 = sc.nextInt();
		int S = sc.nextInt();
		
		System.out.println(S*2 - R1);
		
		sc.close();
	}
}
