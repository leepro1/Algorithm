//https://www.acmicpc.net/problem/17626
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17626 {
	static int min=Integer.MAX_VALUE; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
	
		fourSquares(n,0);
		
		System.out.println(min);
	}
	
	static void fourSquares(int n,int cnt) {
		if(cnt>=min) return;
		if(n==0) {
			min=Math.min(min, cnt);
			return;
		} 
			
		int sqrt=(int)Math.sqrt(n);
		
		for(int i=sqrt;i>=sqrt/2;i--) {
			fourSquares(n-i*i,cnt+1);
		}
	}
}
