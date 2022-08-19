//https://www.acmicpc.net/problem/2630
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630 {
	private static boolean[][] matrix; //0은 false, 1은 true
	private static int zeroCnt=0;
	private static int oneCnt=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		matrix=new boolean[N][N];
		
		for (int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				if(st.nextToken().equals("0"))
					matrix[i][j]=false;
				else
					matrix[i][j]=true;
			}
		}
		divideAndCnt(0,0,N);
		
		System.out.println(zeroCnt+"\n"+oneCnt);
	}
	
	private static void divideAndCnt(int row,int col,int size) {
		if(check(row,col,size)) {
			if(matrix[row][col]==false)
				zeroCnt++;
			else
				oneCnt++;
		}
		
		else {
			int cutSize=size/2;
			
			for(int i=row;i<row+size;i+=cutSize) {
				for(int j=col;j<col+size;j+=cutSize) {
					divideAndCnt(i,j,cutSize);
				}
			}
		}
	}
	
	private static boolean check(int row,int col,int size) {
		
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(matrix[i][j]!=matrix[row][col])
					return false;
			}
		}
		
		return true;
	}
}
