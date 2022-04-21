package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1158 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Queue<Integer> que=new LinkedList<>();
		StringBuilder sb=new StringBuilder("<");
		
		int N=sc.nextInt();
		int K=sc.nextInt();
		
		for(int i=1;i<=N;i++)
			que.add(i);
		
		while(N-->1) {
			
			for(int i=0;i<K-1;i++)
				que.add(que.poll());
			
			sb.append(que.poll()).append(", ");
		}
		sb.append(que.poll()).append(">");
		System.out.println(sb);
		
		sc.close();
	}
}
