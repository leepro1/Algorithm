//https://www.acmicpc.net/problem/2407
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B2407 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		BigInteger numerator=new BigInteger("1");
		BigInteger denominator=new BigInteger("1");
		
		for(int i=0;i<m;i++) {
			numerator=numerator.multiply(new BigInteger(String.valueOf(n-i)));
			denominator=denominator.multiply(new BigInteger(String.valueOf(i+1)));
		}
		
		System.out.println(numerator.divide(denominator));
	}
}
