//https://www.acmicpc.net/problem/11725
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11725 {
	private static int[] treeParent;
	private static int[][] noParent;
	private static int cnt=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		treeParent=new int[N+1];
		noParent=new int[N+1][1];
		
		while(N-->1) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			
			findParent(n1,n2);
		}
		
		for(int i=2;i<treeParent.length;i++) {
			sb.append(treeParent[i]+"\n");
		}
		for(int i=0;i<cnt;i++) {
			findParent(noParent[i][0],noParent[i][1]);
		}
		
		System.out.println(sb);
	}
	
	private static void findParent(int a,int b) {
		if(a==1 || treeParent[a]!=0) {
			treeParent[b]=a;
		}
		
		if(b==1 || treeParent[b]!=0) {
			treeParent[a]=b;
		}
		
		if(treeParent[b]!=0 && treeParent[a]!=0) {
			noParent[cnt][0]=a;
			noParent[cnt][1]=b;			
			cnt++;
		}
	}
}
