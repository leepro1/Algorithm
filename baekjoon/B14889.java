//https://www.acmicpc.net/problem/14889
/*
 * 스타트와 링크 - 백트래킹
 * 일명 가지치기로 재귀를 돌면서 해가 될 수 없는 경우는 되돌아간다.
 * visited를 이용하여 팀을 true/false로 구별한다.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14889 {
	static int[][] stats;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		stats = new int[n][n];
		visited =new boolean[n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				stats[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		System.out.println(min);
	}
	
	static void dfs(int start, int depth) {
		if(depth==n/2) {
			sumScore();
			return;
		}
		
		for (int i = start; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, depth + 1);
				visited[i] = false;
			}
		}
		
	}
	
	static void sumScore() {
		int gap=0;
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(visited[i] && visited[j]) {
					gap+=stats[i][j];
					gap+=stats[j][i];
				}
				else if(!visited[i] && !visited[j]) {
					gap-=stats[i][j];
					gap-=stats[j][i];
				}
			}
		}
		
		//차이가 0이면
		if(gap==0) {
			System.out.println(0);
			System.exit(0);
		}
		
		gap=Math.abs(gap);
		min=Math.min(min, gap);
	}
}
