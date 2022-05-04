//https://www.acmicpc.net/problem/1966
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1966 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		Queue<Integer> queue=new LinkedList<>();
		
		int T=Integer.parseInt(br.readLine());
		int doc=0;
		int temp;
		int cnt=0;
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		while(T-->0) {
			st=new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			ArrayList<Integer> list=new ArrayList<>();
			
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				temp=Integer.parseInt(st.nextToken());
				if(i==M)
					doc=temp;
				list.add(temp);
				queue.offer(temp);
			}
			
			list.sort(Comparator.reverseOrder());
			
			for(int i=0;;) {
				temp=list.get(i);
				if(temp==doc)
					break;
				else if(temp==queue.peek()) {
					queue.remove();
					cnt++;
					i++;
				}
				else
					queue.offer(queue.poll());
			}
			sb.append(cnt).append("\n");
			cnt=0;
			queue.clear();
		}
		System.out.println(sb);
	}
}
