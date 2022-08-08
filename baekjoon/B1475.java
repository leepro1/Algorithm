//https://www.acmicpc.net/problem/1475
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		int[] setNum=new int[10];
		
		while(N>0){
			setNum[N%10]++;
			N/=10;
		}
		
		int sixNine=(setNum[6]+setNum[9])/2;
		if(sixNine%2==0)
			setNum[6]=sixNine;
		else
			setNum[6]=sixNine+1;
		
		setNum[9]=0;
		
		int max=0;
		
		for(int i=0;i<10;i++) {
			if(max<setNum[i])
				max=setNum[i];
		}
		
		System.out.println(max);
	}
}
