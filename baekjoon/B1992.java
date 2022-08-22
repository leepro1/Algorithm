//https://www.acmicpc.net/problem/1992
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1992 {
	private static int[][] matrix;
	private static int compressNum;
	private static StringBuilder sb=new StringBuilder('(');
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		matrix=new int[N][N];
		
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<N;j++) {
				matrix[i][j]=Character.getNumericValue(str.charAt(j)); //char -> int
			}
		}
		
		divideAndCompress(0,0,N);

		System.out.println(sb);
	}
	
	private static void divideAndCompress(int row,int col,int size) {
		if(check(row,col,size)) {
			sb.append(compressNum);
		}
		else {
			sb.append('(');
			int newSize=size/2;
			
			for(int i=row;i<row+size;i+=newSize) {
				for(int j=col;j<col+size;j+=newSize) {
					divideAndCompress(i,j,newSize);
				}
			}
			sb.append(')');
		}
	}
	
	private static boolean check(int row,int col,int size) {
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(matrix[i][j]!=matrix[row][col]) {
					return false;
				}
			}
		}
		compressNum=matrix[row][col];
		return true;
	}
	
}
