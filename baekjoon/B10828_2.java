package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10828_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		Stack<Integer> stack=new Stack<>();
		
		int num=Integer.parseInt(st.nextToken());
		int item;
		
		while(num-->0) {
			st=new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			
			case "push":
				item=Integer.parseInt(st.nextToken());
				stack.push(item);
				break;
				
			case "pop":
				if(stack.size()==0)
					sb.append(-1).append("\n");
				else
					sb.append(stack.pop()).append("\n");	
				break;
				
			case "size":
				sb.append(stack.size()).append("\n");
				break;
				
			case "empty":
				if(stack.empty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");	
				break;
				
			case "top":
				if(stack.empty())
					sb.append(-1).append("\n");
				else
					sb.append(stack.peek()).append("\n");	
				break;
			}
		}
		System.out.println(sb);
	}
}
