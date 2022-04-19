package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		LinkedList<Integer> list=new LinkedList<>();
		
		int num=Integer.parseInt(st.nextToken());
		int item;
		while(num-->0) {
			st=new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			
			case "push_front":
				item=Integer.parseInt(st.nextToken());
				list.addFirst(item);
				break;
				
			case "push_back":
				item=Integer.parseInt(st.nextToken());
				list.addLast(item);
				break;
				
			case "pop_front":
				if(list.size()==0)
					sb.append(-1).append("\n");
				else {
					item=list.removeFirst();
					sb.append(item).append("\n");
				}
				break;
				
			case "pop_back":
				if(list.size()==0)
					sb.append(-1).append("\n");
				else {
					item=list.removeLast();
					sb.append(item).append("\n");
				}
				break;
				
			case "size":
				sb.append(list.size()).append("\n");
				break;
				
			case "empty":
				if(list.size()==0)
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");	
				break;
				
			case "front":
				if(list.size()==0)
					sb.append(-1).append("\n");
				else
					sb.append(list.peek()).append("\n");	
				break;
				
			case "back":
				if(list.size()==0)
					sb.append(-1).append("\n");
				else
					sb.append(list.peekLast()).append("\n");	
				break;
			}
		}
		System.out.println(sb);
	}
}
