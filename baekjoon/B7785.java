//https://www.acmicpc.net/problem/7785
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B7785 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		TreeSet<String> set=new TreeSet<String>();
		
		while(N-->0) {
			st=new StringTokenizer(br.readLine());
			String key=st.nextToken();
			String InOut=st.nextToken();
			
			if(InOut.equals("enter")) {
				set.add(key);
			}
			
			else {
				set.remove(key);
			}
			
		}
		
		StringBuilder sb=new StringBuilder();
		
		for(String name: set.descendingSet()) {
			sb.append(name).append("\n");
		}
		
		System.out.println(sb);
	}
}
