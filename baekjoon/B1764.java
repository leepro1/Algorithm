//https://www.acmicpc.net/problem/1764
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B1764 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		HashSet<String> set = new HashSet<String>();
		ArrayList<String> list = new ArrayList<>();
		StringBuffer sb=new StringBuffer();
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		while(N-->0) {
			set.add(br.readLine());
		}
		while(M-->0) {
			String str=br.readLine();
			if(set.contains(str)) {
				list.add(str);
			}
		}
		Collections.sort(list);
		int num=0;
		
		for (String name : list) {
			 sb.append(name).append("\n");
			 num++;
		}
		 System.out.println(num+"\n"+sb);
	}
}
