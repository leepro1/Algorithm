package baekjoon;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class B2579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(br.readLine());
		int[] score=new int[num];
		
		for(int i=0; i<num;i++) {
			score[i]=Integer.parseInt(br.readLine());
		}
		
		int[] dp=new int[num];
		dp[0]=score[0];
		
		
	}
}
