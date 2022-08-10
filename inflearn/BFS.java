package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
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
        
		StringBuilder bfsResult = new StringBuilder();
        
        boolean[] bfsVisited = new boolean[N+1];
        
        bfs(V, bfsVisited, bfsResult);
        
        System.out.println(bfsResult);
    }
    
	public static void bfs(int node, boolean[] visited, StringBuilder sb) {
		Queue<Integer> queue = new LinkedList<Integer>();
        
		queue.offer(node);
        
		while(!queue.isEmpty()) {
			node = queue.poll();
            
			if(visited[node]) continue;
            
			visited[node] = true;
			sb.append(node + " ");
            
			for(int nextNode:nodeList[node]) {
				queue.add(nextNode);
			}
        }
    }
}
