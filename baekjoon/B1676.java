package baekjoon;

import java.util.Scanner;
import java.math.BigInteger;

public class B1676 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		BigInteger N=sc.nextBigInteger();		
		
		N=factorial(N);
		
		BigInteger ten=new BigInteger("10");

		int cnt=0;
		
		while(N.remainder(ten).intValue()==0) {
			cnt++;
			N=N.divide(ten);
		}
		
		System.out.println(cnt);
		sc.close();
	}
	
	private static BigInteger factorial(BigInteger n) {
		BigInteger one=new BigInteger("1");
		if(n.intValue()==0 || n.compareTo(one)==0)
			return one;
		return n.multiply(factorial(n.subtract(one)));
	}
}
