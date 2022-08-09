//https://www.acmicpc.net/problem/1475
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String N=br.readLine();
		
		int[] setNum=new int[10];
		
		
		for(int i=0;i<N.length();i++) {
			setNum[N.charAt(i) - '0']++;
		}
		
		setNum[6]=setNum[6]+setNum[9];
		setNum[9]=0;
		setNum[6]=setNum[6]/2+setNum[6]%2;
		
		int max=0;
		
		for(int i=0;i<10;i++) {
			if(max<setNum[i])
				max=setNum[i];
		}
		
		System.out.println(max);
	}
}
