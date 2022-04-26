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
		int length=str.length();
		
		while(start<length) {
			
			char temp=str.charAt(start);
			
			if(temp=='c') {
				if(start<length-1){
					if(str.charAt(start+1)=='=' || str.charAt(start+1)=='-')
						start++;
				}
			}
				
			else if(temp=='d') {
				if(start<length-1){
					if(str.charAt(start+1) == 'z') {
						if(start<length-2) {
							if(str.charAt(start+2)=='=')
								start+=2;
						}
					}
					else if(str.charAt(start+1) == '-')
						start++;
				}
			}
					
			else if(temp=='l') {
				if(start<length-1){
					if(str.charAt(start+1)=='j')
						start++;
				}	
			}
				
			else if(temp=='n') {
				if(start<length-1){
					if(str.charAt(start+1)=='j')
						start++;
				}
			}
				
			else if(temp=='s') {
				if(start<length-1){
					if(str.charAt(start+1)=='=')
						start++;
				}
			}
				
			else if(temp=='z') {
				if(start<length-1){
					if(str.charAt(start+1)=='=')
						start++;
				}
			}
			start++;
			cnt++;
		}
		System.out.println(cnt);
	}
}