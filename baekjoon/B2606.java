//https:www.acmicpc.net/problem/2606
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B2606 {
	public static LinkedList<Integer>[] edgeArr;
	public static int cnt=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int vertexNum=Integer.parseInt(br.readLine());
		int edgeNum=Integer.parseInt(br.readLine());
		edgeArr=new LinkedList[vertexNum+1];
		
		for(int i=1;i<=vertexNum;i++) {
			edgeArr[i]=new LinkedList<Integer>();
		}
		
		for(int i=0;i<edgeNum;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			edgeArr[x].add(y);
			edgeArr[y].add(x);
			   
            Collections.sort(edgeArr[x]);
            Collections.sort(edgeArr[y]);
		}
		
		boolean[] visited=new boolean[vertexNum+1];
				
		dfs(1, visited);
		
		System.out.println(cnt-1);
	}
	
	public static void dfs(int node, boolean[] visited) {
		if(visited[node]) return;
	    
		visited[node] = true;
		cnt++;
		
	    for(int nextNode:edgeArr[node]) {
	    	dfs(nextNode, visited);
	    }
	}
}
