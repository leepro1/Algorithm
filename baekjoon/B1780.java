//https://www.acmicpc.net/problem/1780
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1780 {
	static int[][] matrix;
	static int minusCnt=0;
	static int zeroCnt=0;
	static int plusCnt=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		matrix=new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				matrix[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		divideAndCnt(0,0,N);
		
		System.out.println(minusCnt+"\n"+zeroCnt+"\n"+plusCnt);
	}
	
	public static void divideAndCnt(int row,int col,int size) {
		if(check(row,col,size)) {
				if(matrix[row][col]==-1)
					minusCnt++;
				if(matrix[row][col]==0)
					zeroCnt++;
				if(matrix[row][col]==1)	
					plusCnt++;
			}
		else {
			int cutSize=size/3;
			
			for(int i=row;i<row+size;i+=cutSize) {
				for(int j=col;j<col+size;j+=cutSize)
					divideAndCnt(i,j,cutSize);
			}
		}
	}
	
	public static boolean check(int row,int col,int size) {
		int tempValue=matrix[row][col];
		
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(tempValue!=matrix[i][j])
					return false;
			}
		}
		return true;
	}
}
