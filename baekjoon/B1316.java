//https://www.acmicpc.net/problem/1316
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1316 {
	public static boolean[] flag=new boolean[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int cnt=0;
		
		while(N-->0) {
			if(check(br.readLine())) {
				cnt++;
			}
			flag=new boolean[26];
		}
		System.out.println(cnt);
	}
	public static boolean check(String str) {
		int oldChar=0;
		
		for(int i=0;i<str.length();i++) {
			int newChar=str.charAt(i);
			
			if(oldChar!=newChar) {
				if(flag[newChar-'a']) {
					return false;
				}
				else {
					flag[newChar-'a']=true;
					oldChar=newChar;
				}
			}
			else {
				continue;
			}
		}
		return true;
	}
}
