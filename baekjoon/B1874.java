package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class B1874 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Stack<Integer> stack=new Stack<>();
		StringBuilder sb=new StringBuilder();
		
		int n=sc.nextInt();
		
		int cnt=1;
		
		while(n>0) {
			
			int element=sc.nextInt();
				
			if(element>=cnt) {
				while(element>=cnt) {
					stack.push(cnt);
					sb.append("+\n");
					cnt++;
				}
			}
			
			else if(stack.peek()!=element) {
				System.out.println("NO");
				sb.setLength(0);
				break;
			}
			stack.pop();
			sb.append("-\n");
			n--;
		}
		System.out.println(sb);
		
		sc.close();
	}
}
