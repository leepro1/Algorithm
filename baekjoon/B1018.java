//https://www.acmicpc.net/problem/1018
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		char[][] arr=new char[N][M];
		
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<M;j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		
		int result=50*50;
		for(int i=0;i<N-7;i++) {
			for(int j=0;j<M-7;j++) {
				result=Math.min(result,chessCnt(i,j,arr));
			}	
		}
		System.out.println(result);
	}
	private static int chessCnt(int x,int y,char[][] arr) {
		int Bcnt=0;
		int Wcnt=0;
		
		for(int i=x;i<=x+7;i++) {
			for(int j=y;j<=y+7;j++) {
				if((i+j)%2==0) {
					if(arr[i][j]=='B')
						Wcnt++;
					else
						Bcnt++;
				}
				else {	
					if(arr[i][j]=='W')
						Wcnt++;
					else
						Bcnt++;
				}
			}
		}
		return Math.min(Bcnt, Wcnt);
	}
}
