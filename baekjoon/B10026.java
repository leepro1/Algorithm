//https://www.acmicpc.net/problem/10026
/* 
 * 적록색약 - 그래프
 * 구역의 개수를 구하는 흔한 문제이지만 빨간색과 초록색을 같게 취급해서도 출력을 해야한다.
 * 방법 1) 정상과 적록색약 2개의 배열을 만들어 문제를 푼다
 * 방법 2) 개수를 셀 때 빨간색과 초록색을 동일 취급하여 문제를 푼다.
 * BFS를 사용하여 방법 1로 풀어보자. 
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B10026 {
	static private boolean[][] visited1;
	static private boolean[][] visited2;
	static private int[][] color1;
	static private int[][] color2;
	static private int[] dx = {-1,1,0,0};
	static private int[] dy = {0,0,-1,1};
	static private int n;
	static private Queue<int[]> queue = new LinkedList<int[]>(); // bfs로 풀기 위한 queue
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		visited1=new boolean[n][n]; //정상 버전
		visited2=new boolean[n][n]; //적록색약 버전
		color1=new int[n][n]; //정상 버전
		color2=new int[n][n]; //적록색약 버전
		
		//r=1, g=2, b=3 으로 표시하고 적록색약의 경우 r=g=1로한다.
		for(int i=0;i<n;i++) {
			String str=br.readLine();
			for(int j=0;j<n;j++) {
				if(str.charAt(j)=='R') {
					color1[i][j]=1;
					color2[i][j]=1;
				}
				else if(str.charAt(j)=='G') {
					color1[i][j]=2;
					color2[i][j]=1;
				}
				else {
					color1[i][j]=3;
					color2[i][j]=3;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited1[i][j]) {
					queue.offer(new int[] {i,j});
					visited1[i][j]=true;
					bfs1();	
				}
			}
		}
		
	}
	
	private static void bfs1() {
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = temp[0] + dx[i];
				int nextY = temp[1] + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
					continue;
				if (color1[nextX][nextY] == color1[temp[0]][temp[1]] && !visited1[nextX][nextY]) {
					visited1[nextX][nextY]=true;
					queue.offer(new int[] { nextX, nextY });
				}
			}
		}
	}
}
