package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class B10814 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		String[][] arr=new String[N][2];
		
		for(int i=0;i<N;i++) {
			arr[i][0]=sc.next();
			arr[i][1]=sc.next();
		}
		
		Arrays.sort(arr, (o1, o2) -> { 
			return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
		});

		for(int i=0;i<N;i++) {
			sb.append(arr[i][0]+" "+arr[i][1]+"\n");
		}
		
		System.out.println(sb);
		
		sc.close();
	}
}
