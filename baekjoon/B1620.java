//https://www.acmicpc.net/problem/1620
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B1620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		HashMap<String,String> map = new HashMap<String,String>();
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=N;i++) {
			String str=br.readLine();
			map.put(Integer.toString(i),str);
			map.put(str,Integer.toString(i));
		}
		
		while(M-->0) {
			String str=br.readLine();
			if (map.containsKey(str)) {
				sb.append(map.get(str)).append("\n");
			}
		}
		System.out.println(sb);
	}
}
