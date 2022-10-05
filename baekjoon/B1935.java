//https://www.acmicpc.net/problem/1935
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());	
		int[] numArr=new int[N];
		String str=br.readLine();
		
		for(int i=0;i<N;i++) {
			numArr[i]=Integer.parseInt(br.readLine());
		}
		
		Stack<Double> stack =new Stack<>();
	
		for(int i=0;i<str.length();i++) {
			if('A'<=str.charAt(i)&& str.charAt(i)<='Z') {
				stack.push((double)numArr[str.charAt(i)-'A']);
			}
			else {
				double temp1=stack.pop();
				double temp2=stack.pop();
				double tempResult=0.0;
				
				switch(str.charAt(i)) {
					case '+':
						tempResult=temp2 + temp1;
						break;
						
					case '-':
						tempResult=temp2 - temp1;
						break;
						
					case '*':
						tempResult=temp2 * temp1;
						break;
						
					case '/':
						tempResult=temp2 / temp1;
						break;
				}
				stack.push(tempResult);
			}
		}
		System.out.printf("%.2f",stack.pop());
	}
}
