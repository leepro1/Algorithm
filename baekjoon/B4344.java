package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B4344 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int C=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<C;i++) {
			int upCnt=0;
			double sum=0;
			double avg=0;
			
			st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int[] arr=new int[N];
			
			for(int j=0;j<N;j++) {
				arr[j]=Integer.parseInt(st.nextToken());
				sum+=arr[j];
			}
			
			avg=sum/N;
			
			for(int k=0;k<N;k++) {
				if(arr[k]>avg)
					upCnt++;
			}
			System.out.printf("%.3f",(double)100*upCnt/N);
			System.out.println("%");
		}
	}
}
