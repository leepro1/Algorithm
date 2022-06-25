//https://www.acmicpc.net/problem/11047
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int[] arr=new int[N];
		
		int maxindex=0;
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
			if(K/arr[i]>0) {
				maxindex=i;
			}
		}
		
		for(int i=maxindex;i>=0;i--) {
			cnt+=K/arr[i];
			K=K%arr[i];
		}
		System.out.println(cnt);
	}
}
