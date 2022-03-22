package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		
		int count=1;
		int i=666;
		
		while(count!=N) {
			i++;
			if(Integer.toString(i).contains("666"))  // 문자열 검색->contains, indexOf, matches
				count++;
				
		}
		System.out.println(i);
	}
}
