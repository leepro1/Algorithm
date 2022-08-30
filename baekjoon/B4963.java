//https://www.acmicpc.net/problem/4963
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B4963 {
	private static int[][] matrix;
	private static boolean[][] visited;
	private static int cnt;
	private static int[] checkH= {-1,-1,-1,0,0,1,1,1};
	private static int[] checkW= {-1,0,1,-1,1,-1,0,1};
	private static int w,h;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w=Integer.parseInt(st.nextToken());
			h=Integer.parseInt(st.nextToken());
			
			if(w==0 && h==0) break;
			matrix=new int[h][w]; //1은 땅, 0은 바다이다.
			visited=new boolean[h][w];
			cnt=0;
			
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					matrix[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(!visited[i][j] && matrix[i][j]==1) {
						cntIsland(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
	
	private static void cntIsland(int r, int c) {
		visited[r][c]=true;
		
		for(int i=0;i<8;i++) {
			if(r+checkH[i]<0 || r+checkH[i]>=h || c+checkW[i]<0 || c+checkW[i]>=w ) { continue;}
			if(matrix[r+checkH[i]][c+checkW[i]]==1 && !visited[r+checkH[i]][c+checkW[i]]) {
				cntIsland(r+checkH[i],c+checkW[i]);
			}
		}
	}
}
