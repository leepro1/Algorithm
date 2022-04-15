package baekjoon;

import java.util.Scanner;

public class B10845 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		
		int N=sc.nextInt();
		int[] queue=new int[N];
		int front=-1;
		int rear=-1;
		
		for(int i=0;i<N;i++) {
			String str=sc.next();
			
			switch(str) {
			
			case "push": //꽉찼을때
				rear++;
				queue[rear]=sc.nextInt();
				break;

			case "pop":
				if(rear==front)
					sb.append(-1+"\n");
				else {
					front++;
					sb.append(queue[front]+"\n");
				}
				break;

			case "size":
				sb.append(rear-front+"\n");
				break;

			case "empty":
				if(rear==front)
					sb.append(1+"\n");
				else
					sb.append(0+"\n");;
				break;

			case "front":
				if(rear==front)
					sb.append(-1+"\n");
				else
					sb.append(queue[front+1]+"\n");
				break;
			
			case "back":
				if(rear==front)
					sb.append(-1+"\n");
				else
					sb.append(queue[rear]+"\n");
				break;
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
