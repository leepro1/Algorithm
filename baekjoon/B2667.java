package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class B2667 {
	private static int[][] matrix;
	private static boolean[][] visited;
	private static LinkedList<Integer> apartCnt=new LinkedList<Integer>();
	private static int tempCnt;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		matrix=new int[N][N];
		visited=new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String temp=br.readLine();
			for(int j=N-1;j>=0;j--) {
				matrix[i][j]=temp.charAt(j)-'0';
			}
		}
		int apartNum=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(matrix[i][j]==1) {
					if(matrix[i][j]==1 && !visited[i][j]) {
						dfs(i,j);
						apartNum++;
						apartCnt.add(tempCnt);
						tempCnt=0;
					}
				}
			}
		}
		
		StringBuilder sb=new StringBuilder();
		sb.append(apartNum+"\n");
		
		Collections.sort(apartCnt);
		
		for(int i:apartCnt) {
			sb.append(i+"\n");
		}
		
		System.out.println(sb);
	}
	
	public static void dfs(int x,int y) {
		visited[x][y]=true;		
		tempCnt++;
		
		if(x-1>=0 && matrix[x-1][y]==1 && !visited[x-1][y])
			dfs(x-1,y);
		if(x+1<N && matrix[x+1][y]==1 && !visited[x+1][y])
			dfs(x+1,y);
		if(y-1>=0 && matrix[x][y-1]==1 && !visited[x][y-1])
			dfs(x,y-1);
		if(y+1<N && matrix[x][y+1]==1 && !visited[x][y+1])
			dfs(x,y+1);
	}
}
