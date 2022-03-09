package baekjoon;

import java.util.Scanner;

public class B17256 {
	static Scanner sc = new Scanner(System.in); //only one
	public static void main(String[] args) {
		
		int[] a = new int[3];
		int[] b = new int[3];
		int[] c = new int[3];
		
		a = scanIntArr(a);
		c = scanIntArr(c);
		
		b[0] = c[0] - a[2];
		b[1] = c[1] / a[1];
		b[2] = c[2] - a[0];
		
		System.out.println(b[0]+" "+b[1]+" "+b[2]);
	}
	public static int[] scanIntArr(int n[]) {
		for(int i=0;i<3;i++) {
			n[i] = sc.nextInt();
		}
		
		return n;
	}
}
