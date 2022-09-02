//https://www.acmicpc.net/problem/11725
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B11725 {
	private static int[] treeParent;
	private static LinkedList<int[]> noParent=new LinkedList<int[]>();
	private static boolean flag=false;
	private static boolean removeFlag=false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		treeParent=new int[N+1];
		
		while(N-->1) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n1=Integer.parseInt(st.nextToken());
			int n2=Integer.parseInt(st.nextToken());
			
			findParent(n1,n2);
		}
	
		flag=true;
		
		for(int i=0;!noParent.isEmpty();i++) {
			findParent(noParent.get(i)[0],noParent.get(i)[1]);
			
			if(removeFlag==true) {
				noParent.remove(i);
				removeFlag=false;
				i--;
			}
			if(i==noParent.size()) i=0;
			
		}
		
		for(int i=2;i<treeParent.length;i++) {
			sb.append(treeParent[i]+"\n");
		}
		
		System.out.println(sb);
	}
	
	private static void findParent(int a,int b) {
		if(a==1 || treeParent[a]!=0) {
			treeParent[b]=a;
			if(flag==true) removeFlag=true;
		}
		
		else if(b==1 || treeParent[b]!=0) {
			treeParent[a]=b;
			if(flag==true) removeFlag=true;
		}
		
		else if(flag==false && treeParent[b]==0 && treeParent[a]==0) {
			noParent.add(new int[] {a,b});
		}
	}
}
