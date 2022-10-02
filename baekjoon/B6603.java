//https://www.acmicpc.net/problem/6603
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6603 {
	private static StringBuilder sb= new StringBuilder();;
	private static int[] num;
	private static boolean[] visited;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			
			if(N==0) break;
			
			num=new int[N];
			visited=new boolean[N];
			
			for(int i=0;i<N;i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
			
			lotto(0,0);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void lotto(int start, int end) {
		if(end==6) {
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					sb.append(num[i]+" ");
				}
			}
			sb.append("\n");
		}
		
		
		for(int i=start;i<N;i++) {
			visited[i]=true;
			lotto(i+1,end+1);
			visited[i]=false;
		}
	}
}
