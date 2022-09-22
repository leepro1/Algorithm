//https://www.acmicpc.net/problem/15654
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15654 {
	public static int[] arr;
	public static int[] numArr;
	public static boolean[] visited;
	public static int N,M;
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());

		arr = new int[M];
		numArr = new int[N];
		visited = new boolean[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			numArr[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numArr);
		
		dfs(0,0);
		System.out.println(sb);
		
	}
	public static void dfs(int start,int depth) {
		if (depth == M) {
			for (int val : arr) {
				sb.append(val+" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr[depth]=numArr[i];
				dfs(i+1, depth+1);
				visited[i]=false;
			}
		}
	}
}
