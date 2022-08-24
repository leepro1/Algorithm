//https://www.acmicpc.net/problem/6064
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6064 {
	private static int M,N,x,y;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();		

		while(T-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken());
			sb.append(calendar()+"\n");
		}
		System.out.println(sb);
	}
	
	private static int calendar(){
		for(int i=0;i*M<lcm(M,N);i++) {
			if((i*M+x-y)%N==0) {
				return i*M+x;
			}
		}
		return -1;
	}
	
	private static int gcd(int a,int b) {
		if(b==0) return a;
		
		return gcd(b,a%b);
	}
	
	private static int lcm(int a,int b) {
		return a*b/gcd(a,b);
	}
}
