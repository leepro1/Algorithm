package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class B2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str =br.readLine();
		
		int start=0;
		int cnt=0;
		
		while(start<str.length()) {
			if(str.charAt(start)=='c') {
				if(start<=str.length()){
					if(str.charAt(start+1)=='=')
						start++;
				}
				else if(str.charAt(start+1)=='-')
					start++;
			}
				
			else if(str.charAt(start)=='d') {
				if(start<=str.length()){
					if(str.charAt(start+1) == 'z') {
						if(start<=str.length()-1) {
							if(str.charAt(start+2) =='=')
								start+=2;
						}
					}
					else if(str.charAt(start+1) == '-')
						start++;
				}
			}
					
			else if(str.charAt(start)=='l') {
				if(start<=str.length()){
					if(str.charAt(start+1)=='j')
						start++;
				}	
			}
				
			else if(str.charAt(start)=='n') {
				if(start<=str.length()){
					if(str.charAt(start+1)=='j')
						start++;
				}
			}
				
			else if(str.charAt(start)=='s') {
				if(start<=str.length()){
					if(str.charAt(start+1)=='=')
						start++;
				}
			}
				
			else if(str.charAt(start)=='z') {
				if(start<=str.length()){
					if(str.charAt(start+1)=='=')
						start++;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}