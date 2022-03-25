package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class B4949 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		Stack<Character> stack=new Stack<>();

		while(true) {
			String str=sc.nextLine();
			if(str.equals("."))
				break;
			
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='(' || str.charAt(i)=='[' ) {
					stack.push(str.charAt(i));
				}
				else if(str.charAt(i)==')') {
					if(stack.size()==0) {
						stack.push(')');
						break;
					}
					else if(stack.peek().equals('('))
						stack.pop();
					else
						break;
				}
				else if(str.charAt(i)==']') {
					if(stack.size()==0) {
						stack.push(']');
						break;
					}
					else if(stack.peek().equals('['))
						stack.pop();
					else
						break;
				}
			}
			if(stack.empty())
				System.out.println("yes");
			else
				System.out.println("no");
			stack.clear();
		}
		sc.close();
	}
}
