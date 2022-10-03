//https://www.acmicpc.net/problem/1182
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1182 {
	private static int cnt=0;
	private static int S,N;
	private static int depth=1;
	private static int[] num;
	private static int[] subNum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		
		num=new int[N];
		subNum=new int[N];
		
		st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			num[i]=Integer.parseInt(st.nextToken());
		}
		
		while(depth<=N) {
			subsequnceCnt(0,0);
			depth++;
		}
		System.out.println(cnt);
	}
	
	private static void subsequnceCnt(int index,int end) {
		if(end==depth) {
			int sum=0;
			for(int i=0;i<end;i++) {
				sum+=subNum[i];
			}
			if(sum==S) cnt++;
		}
		
		for(int i=index;i<N;i++) {
			subNum[end]=num[i];
			subsequnceCnt(i+1,end+1);
		}
	}
}
