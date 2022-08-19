//https://www.acmicpc.net/problem/1074
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1074 {
	private static int cnt=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		
		int size=(int)Math.pow(2, N);
		
		divideAndCnt(r,c,size);
		
		System.out.println(cnt);
	}
	
	private static void divideAndCnt(int row,int col,int size) {
		if(size==1) return;
		
		if(row<size/2 && col<size/2) {
			divideAndCnt(row,col,size/2);
		}
		else if(row<size/2 && col>=size/2) {
			cnt+=size*size/4;
			divideAndCnt(row,col-size/2,size/2);
		}
		else if(row>=size/2 && col<size/2) {
			cnt+=(size*size/4)*2;
			divideAndCnt(row-size/2,col,size/2);
		}
		else {
			cnt+=(size*size/4)*3;
			divideAndCnt(row-size/2,col-size/2,size/2);
		}
	}
}
