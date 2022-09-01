//https://www.acmicpc.net/problem/1931
package baekjoon;
/* 그리디 알고리즘 풀이 - 활동 선택 문제
 * 첫 활동시간 선택 후 끝나는 시간 순으로 정렬
 * 반복문을 통해 집합의 끝나는 시간이 다음 행동의 시작 시간보다 작은 경우 포함
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		int[][] meetingTime=new int[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			meetingTime[i][0]=Integer.parseInt(st.nextToken());
			meetingTime[i][1]=Integer.parseInt(st.nextToken());		
		}
		
		//람다식을 이용하여 정렬
		Arrays.sort(meetingTime,(o1,o2)->{
			if(o1[1]==o2[1]) return o1[0]-o2[0];
			return o1[1]-o2[1];
		});
		
		int last=0; //끝나는 시간
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			if(last<=meetingTime[i][0]) {
				last=meetingTime[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
