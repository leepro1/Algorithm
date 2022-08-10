//https://www.acmicpc.net/problem/1012
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1012 {
	static int[][] matrixGraph;
	static boolean[][] visited;
	
	static int M;
	static int N;
	static int K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			matrixGraph=new int[M][N];
			visited=new boolean[M][N];
			
			while(K-->0) {
				st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				addEdge(x,y);
			}
			
			int cnt=0;
			
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++) {
					if(matrixGraph[i][j]==1) {
						if(matrixGraph[i][j]==1 && !visited[i][j]) {
							dfs(i,j);
							cnt++;
						}
					}
				}
			}
			System.out.println(cnt);
		}
	}
	public static void addEdge(int v1, int v2) {
		matrixGraph[v1][v2]=1;
	}
	
	public static void dfs(int x,int y) {
		visited[x][y]=true;		
		
		if(x-1>=0 && matrixGraph[x-1][y]==1 && !visited[x-1][y])
			dfs(x-1,y);
		if(x+1<M && matrixGraph[x+1][y]==1 && !visited[x+1][y])
			dfs(x+1,y);
		if(y-1>=0 && matrixGraph[x][y-1]==1 && !visited[x][y-1])
			dfs(x,y-1);
		if(y+1<N && matrixGraph[x][y+1]==1 && !visited[x][y+1])
			dfs(x,y+1);
	}
}
