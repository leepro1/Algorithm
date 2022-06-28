//https:www.acmicpc.net/problem/2606
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B2606 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int vertexNum=Integer.parseInt(br.readLine());
		int edgeNum=Integer.parseInt(br.readLine());
		LinkedList<Integer>[] edgeArr=new LinkedList[vertexNum+1];
		
		for(int i=1;i<=vertexNum;i++) {
			edgeArr[i]=new LinkedList<Integer>();
		}
		
		for(int i=0;i<edgeNum;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			edgeArr[x].add(y);
			edgeArr[y].add(x);
		}
		
		boolean[] checkArr=new boolean[vertexNum+1];
		
		for(int i=0;i<edgeArr[1].size();i++) {
			int temp=edgeArr[1].get(i);
			checkArr[edgeArr[1].get(i)]=true;
			
			for(int j=0;j<edgeArr[temp].size();j++) {
				if(checkArr[edgeArr[temp].get(j)]==false) {
					checkArr[edgeArr[temp].get(j)]=true;
				}
			}
		}
		
		int cnt=0;
		for(int i=0;i<checkArr.length;i++) {
			if(checkArr[i]==true)
				cnt++;
		}
		System.out.println(cnt-1); //1번 컴퓨터 제외
	}
}
