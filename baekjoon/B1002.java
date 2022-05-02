//https://www.acmicpc.net/problem/1002
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		while(T-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			double d=Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
			System.out.println(cal(x1, y1, r1, x2, y2, r2, d));
		}
	}
	private static int cal(int x1,int y1,int r1,int x2,int y2,int r2,double d) {
		if(x1==x2 && y1==y2 &&r1==r2)
			return -1;
		else if(d==r1+r2 || Math.abs(r1-r2)==d)
			return 1;
		else if(Math.abs(r1-r2)>d|| x1==x2&&y1==y2&&r1!=r2||d>r1+r2)
			return 0;
		else
			return 2;
	}
}
