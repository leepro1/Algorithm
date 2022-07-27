//https://www.acmicpc.net/problem/1541
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String str=br.readLine();
		StringBuffer sb=new StringBuffer();
		
		boolean minusFlag=false;
		int sum=0;
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)!='-' && str.charAt(i)!='+') {
				sb.append(str.charAt(i));
			}
			if(i+1==str.length() || str.charAt(i)=='-' || str.charAt(i)=='+') {
				if(minusFlag) {
					sum-=Integer.parseInt(sb.toString());
				}
				else {
					sum+=Integer.parseInt(sb.toString());
				}
				sb.setLength(0);
			}
			if(str.charAt(i)=='-') {
				minusFlag=true;
			}
		}
		System.out.println(sum);
	}
}
