//https://www.acmicpc.net/problem/5622
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5622 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		
		int sum=0;
		
		for(int i=0;i<str.length();i++) {
			sum+=time(str.charAt(i))+1;
		}
		
		System.out.println(sum);
	}
	public static int time(char c) {
		switch(c) {
			case 'A':
			case 'B':
			case 'C':
				return 2;
			case 'D':
			case 'E':
			case 'F':
				return 3;
			case 'G':
			case 'H':
			case 'I':
				return 4;
			case 'J':
			case 'K':
			case 'L':
				return 5;
			case 'M':
			case 'N':
			case 'O':
				return 6;
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
				return 7;
			case 'T':
			case 'U':
			case 'V':
				return 8;
			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
				return 9;
			default:
				return 0;
		}
	}
}
