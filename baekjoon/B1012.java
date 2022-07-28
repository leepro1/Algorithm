//https://www.acmicpc.net/problem/1012
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1012 {
	public static int[][] matrixGraph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		while(T-->0) {
			matrixGraph=new int[M][N];
			int cnt=0;
			while(K-->0) {
				st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				addEdge(x,y);
			}
			
			System.out.println(cnt);
		}
	}
	public static void addEdge(int v1, int v2) {
		matrixGraph[v1][v2]=1;
	}
	
}
