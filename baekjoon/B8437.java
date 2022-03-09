package baekjoon;

import java.util.Scanner;
import java.math.BigInteger;

public class B8437 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger totalApple = sc.nextBigInteger();
		BigInteger diffApple = sc.nextBigInteger();
		BigInteger two = new BigInteger("2"); //BigInteger의 인자값은 문자열
		
		//문자열이기에 사칙연산 x - 내부메서드 사용
		BigInteger k = (totalApple.subtract(diffApple)).divide(two).add(diffApple); //(total-diff)/2+diff
		BigInteger n = (totalApple.subtract(diffApple)).divide(two); //(total-diff)/2
		
		System.out.println(k);
	    System.out.println(n);
		
	    sc.close();
	}
}
