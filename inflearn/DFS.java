package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DFS {
	public static int N;
	public static LinkedList<Integer>[] nodeList;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
        
		nodeList = new LinkedList[N+1];
        
		for(int i=0; i <= N; i++) {
			nodeList[i] = new LinkedList<Integer>();
		}
        
		for(int i=0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
            
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
            
			nodeList[node1].add(node2);
			nodeList[node2].add(node1);
            
			Collections.sort(nodeList[node1]);
            Collections.sort(nodeList[node2]);
		}
        
		StringBuilder dfsResult = new StringBuilder();
        
        boolean[] dfsVisited = new boolean[N+1];
        
        dfs(V, dfsVisited, dfsResult);
        
        System.out.println(dfsResult);
	} 
	public static void dfs(int node, boolean[] visited, StringBuilder sb) {
		if(visited[node]) return;
        
		visited[node] = true;
		sb.append(node + " ");
		for(int nextNode:nodeList[node]) {
			dfs(nextNode, visited, sb);
		}
	}
}
