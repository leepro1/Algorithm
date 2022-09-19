//https://www.acmicpc.net/problem/1629
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int A=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		
		System.out.println(divideAndConquer(A,B,C));
	}
	
	private static long divideAndConquer(int a,int b,int mod) {
		if(b==0) return 1;
		
		long temp=divideAndConquer(a,b/2,mod);
		
		if(b%2==0)
			return temp*temp%mod;
		else
			return (temp*temp%mod)*a%mod; 
	}
	
}
