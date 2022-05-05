//https://www.acmicpc.net/problem/1966
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		Queue<int[]> queue=new LinkedList<>();
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int T=Integer.parseInt(st.nextToken());
		
		while(T-->0) {
			st=new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int cnt=0;
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				queue.offer(new int[] {i,Integer.parseInt(st.nextToken())});
			}
			
			while(true) {
				int[] head=queue.remove(); //순회하기 때문에 head를 peek 이 아닌 remove
				boolean check=true;
				
				for(int temp[]:queue) {
					if(temp[1]>head[1]) {
						check=false;
						break;
					}
				}
				
				if(check) {
					cnt++;
					if(head[0]==M)
						break;
				}
				else
					queue.offer(head);
			}
			sb.append(cnt).append("\n");
			cnt=0;
			queue.clear();
		}
		System.out.println(sb);
	}
}
