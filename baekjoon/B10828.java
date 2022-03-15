package baekjoon;

import java.util.Scanner;

public class B10828 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
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
					System.out.println(-1);
				else {
					System.out.println(stack[size-1]);
					size--;
				}
				break;

			case "size":
				System.out.println(size);
				break;

			case "empty":
				if(size==0)
					System.out.println(1);
				else
					System.out.println(0);
				break;

			case "top":
				if(size==0)
					System.out.println(-1);
				else
					System.out.println(stack[size-1]);
				break;
			}
		}
		sc.close();
	}
}
