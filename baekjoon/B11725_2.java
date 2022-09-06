//https://www.acmicpc.net/problem/11725
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11725_2 {
	private static boolean[] visited;
	private static int[] parent;
	private static int N;
	private static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		visited=new boolean[N+1];
		parent=new int[N+1];
		list=new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			list[i]=new ArrayList<Integer>();
		}
		
		for(int i=0;i<N-1;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			list[x].add(y);
			list[y].add(x);
		}	
		
		dfs(1);
		
		StringBuilder sb=new StringBuilder();
		for(int i=2;i<parent.length;i++) {
			sb.append(parent[i]+"\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int v) {
		visited[v]=true;
		
		for(int i:list[v]) {
			if(!visited[i]) {
				parent[i]=v;
				dfs(i);
			}
		}
	}
}
