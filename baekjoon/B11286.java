//https://www.acmicpc.net/problem/11286
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B11286 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		
		//람다식으로 절댓값 힙 구현
		PriorityQueue<Integer> queue = new PriorityQueue<>((e1,e2)->{
			int val1=Math.abs(e1);
			int val2=Math.abs(e2);
			
			if(val1==val2) {
				if(e1>e2)
					return 1;
				else
					return -1;
			}
				 
			
			else
				return val1-val2;
		});
			
		while(N-->0) {
			int num=Integer.parseInt(br.readLine());
			
			if(num==0) {
				if(queue.isEmpty()) 
					sb.append("0").append("\n");
				else
					sb.append(queue.poll()).append("\n");
			}
				
			else {
				queue.add(num);
			}
		}
		System.out.println(sb);
	}
}
