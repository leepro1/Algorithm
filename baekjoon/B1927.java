//https://www.acmicpc.net/problem/1927
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B1927 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x));

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
