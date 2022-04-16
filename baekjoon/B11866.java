package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B11866 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Queue<Integer> queue=new LinkedList<>();
		
		StringBuilder sb=new StringBuilder();
		sb.append('<');

		int N=sc.nextInt();
		int K=sc.nextInt();
		
		for(int i=1;i<=N;i++)
			queue.add(i);
		
		while(queue.size()!=1){
			for(int i=0;i<K-1;i++)
				queue.add(queue.poll());
			
			sb.append(queue.poll()).append(", ");
		}
		sb.append(queue.poll()).append(">");
		
		System.out.println(sb);
		sc.close();
	}
}
