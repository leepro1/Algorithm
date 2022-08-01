//https://www.acmicpc.net/problem/18111
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int B=Integer.parseInt(st.nextToken());
		
		int[][] blockArr=new int[N][M];
		
		int time=Integer.MAX_VALUE;
		int height=0;
		int minHeight=256;
		int maxHeight=0;
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());

			for(int j=0;j<M;j++) {
				int inputHeight=Integer.parseInt(st.nextToken());
				blockArr[i][j]=inputHeight;
				if(inputHeight>=maxHeight)
					maxHeight=inputHeight;
				if(inputHeight<=minHeight)
					minHeight=inputHeight;
			}
		}
		
		for(int i=minHeight;i<=maxHeight;i++) {
			int tempTime=0;
			int restBlock=B;
			
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					int diff = blockArr[j][k]-i; //diff는 높이차
					
					if(diff>0) {
						tempTime+=Math.abs(diff)*2;
						restBlock+=Math.abs(diff);
					}
					
					else if(diff<0) {
						tempTime+=Math.abs(diff);
						restBlock-=Math.abs(diff);
					}
					
				}
			}
			if(tempTime<=time && restBlock>=0) {
				time=tempTime;
				height=(i==height)?Math.max(i,height):i;
			}
				
		}
		System.out.println(time+" "+height);
	}
}
