//https://www.acmicpc.net/problem/1541
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String str=br.readLine()+'.';
		
		boolean minusFlag=false;
		int sum=0;
		int tempIndex=0;
		
		for(int i=0;i<str.length();i++) {
			if(i+1==str.length() || str.charAt(i)=='-' || str.charAt(i)=='+') {
				if(str.charAt(i)=='-') {
					minusFlag=true;	
				}
				if(minusFlag==true) {
					sum-=Integer.parseInt(str.substring(tempIndex,i));
				}
				if(minusFlag==false) {
					sum+=Integer.parseInt(str.substring(tempIndex,i));	
				}	
				tempIndex=i+1;
			}
		}
		System.out.println(sum);
	}
}
