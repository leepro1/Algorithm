package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class B10773 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int K=sc.nextInt();
		int tempNum;
		int sum=0;
		Stack<Integer> stack=new Stack<>();
		
		for(int i=0;i<K;i++) {
			tempNum=sc.nextInt();
			if(tempNum!=0)
				stack.push(tempNum);
			else
				stack.pop();
		}
		while(!stack.isEmpty())
			sum+=stack.pop();
		System.out.println(sum);
		sc.close();
	}
}
