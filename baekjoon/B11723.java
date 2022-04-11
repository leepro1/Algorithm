package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11723 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int M=Integer.parseInt(st.nextToken());
		
		boolean[] arr=new boolean[20];
		
		for(int i=0;i<M;i++) {
			
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			int num;
				
			switch(str) {
			
			case "add":
				num=Integer.parseInt(st.nextToken())-1;
				if(arr[num]==false) {
					arr[num]=true;
				}
				break;

			case "remove":
				num=Integer.parseInt(st.nextToken())-1;
				if(arr[num]==true) {
					arr[num]=false;
				}
				break;

			case "check":
				num=Integer.parseInt(st.nextToken())-1;
				if(arr[num]==true) {
					System.out.println(1);
				}
				else
					System.out.println(0);
				break;

			case "toggle":
				num=Integer.parseInt(st.nextToken())-1;
				if(arr[num]==true) {
					arr[num]=false;
				}
				else {
					arr[num]=true;
				}
				break;

			case "all":
				Arrays.fill(arr, true);
				break;
				
			case "empty":
				Arrays.fill(arr, false);
				break;
			}
		}
	}
}
