package baekjoon;

import java.util.Scanner;

public class B15894 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long upSide = n;
		long downSide = n;
		long bothSide = n*2;
		
		System.out.println(upSide+downSide+bothSide);
		
		sc.close();
	}
}
