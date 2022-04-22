package baekjoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class B20301 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Deque<Integer> deq=new LinkedList<>();
		StringBuilder sb=new StringBuilder();
		
		int N=sc.nextInt();
		int K=sc.nextInt();
		int M=sc.nextInt();
		int cnt=0;
		
		for(int i=1;i<=N;i++)
			deq.add(i);
		
		while(N-->0) {
			if((cnt/M)%2==0) {
				for(int i=0;i<K-1;i++)
					deq.offer(deq.poll());
				sb.append(deq.pollFirst()).append("\n");
				cnt++;
			}
			else {
				for(int i=0;i<K-1;i++)
					deq.offerFirst(deq.pollLast());
				sb.append(deq.pollLast()).append("\n");
				cnt++;
			}
			
		}
		System.out.println(sb);
		
		sc.close();
	}
}
