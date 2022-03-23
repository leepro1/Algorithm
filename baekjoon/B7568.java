package baekjoon;

import java.util.Scanner;

public class B7568 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		StringBuilder sb =new StringBuilder();
		
		int N=sc.nextInt();
		int[][] arr=new int[N][2];
		
		for(int i=0;i<N;i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		
		for(int i=0;i<N;i++) {
			int rank=1;
			for(int j=0;j<N;j++) {
				if(i==j)
					continue;
				if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1])
					rank++;
			}
			sb.append(rank+" ");
		}
		
		
		System.out.println(sb);
		sc.close();
	}
}
