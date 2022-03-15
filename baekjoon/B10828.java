package baekjoon;

import java.util.Scanner;

public class B10828 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder();
		
		int N=sc.nextInt();
		int[] stack=new int[N];
		
		int size=0;
		
		
		for(int i=0;i<N;i++) {
			String str=sc.next();
			
			switch(str) {
			
			case "push":
				stack[size]=sc.nextInt();
				size++;
				break;

			case "pop":
				if(size<=0)
					sb.append(-1+"\n");
				else {
					sb.append(stack[size-1]+"\n");
					size--;
				}
				break;

			case "size":
				sb.append(size+"\n");
				break;

			case "empty":
				if(size==0)
					sb.append(1+"\n");
				else
					sb.append(0+"\n");;
				break;

			case "top":
				if(size==0)
					sb.append(-1+"\n");
				else
					sb.append(stack[size-1]+"\n");
				break;
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
