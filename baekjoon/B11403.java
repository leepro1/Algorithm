//https://www.acmicpc.net/problem/11403
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11403 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		boolean[][] matrix=new boolean[N][N]; 
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				if(st.nextToken().equals("1"))
					matrix[i][j]=true;
				else
					matrix[i][j]=false;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<N;k++) {
					if(matrix[k][i]==true && matrix[i][j]==true)
						matrix[k][j]=true;
				}
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(matrix[i][j]==true)
					sb.append(1+" ");
				else
					sb.append(0+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
