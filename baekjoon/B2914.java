package baekjoon;

import java.util.Scanner;

public class B2914 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int I = sc.nextInt();
		
		System.out.println(A*I-(A-1));
		
		sc.close();
	}
}
