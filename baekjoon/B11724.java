//https://www.acmicpc.net/problem/11724
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B11724 {
	private static LinkedList<Integer>[] nodeList;
	private static boolean[] visited;
	private static int cnt=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		nodeList=new LinkedList[N+1];
		visited=new boolean[N+1];
		
		for(int i=1; i < N+1; i++) {
			nodeList[i] = new LinkedList<Integer>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			
			nodeList[u].add(v);
			nodeList[v].add(u);
		}
		
		for(int node=1;node<visited.length;node++) {
			if(!visited[node]) {
				dfs(node);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	
	private static void dfs(int node) {
		visited[node]=true;
		
		for(int i: nodeList[node]) {
			if(!visited[i]) {
				dfs(i);
			}
		}
		
	}
}
