package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		int[] num=new int[Integer.parseInt(st.nextToken())+1];
		int T=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<num.length;i++) {
			num[i]=num[i-1]+Integer.parseInt(st.nextToken());
		}
		
		while(T-->0) {
			st=new StringTokenizer(br.readLine());
			sb.append(-num[Integer.parseInt(st.nextToken())-1]+num[Integer.parseInt(st.nextToken())]).append("\n");
		}
		
		System.out.println(sb);
	}
}
