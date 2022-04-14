package baekjoon;

import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class B11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int[] arrP=new int[N];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arrP[i]=Integer.parseInt(st.nextToken());
		
		Arrays.sort(arrP);
		
		int sum=0;
		int eachTime=0;
		
		for(int i=0;i<N;i++) {
			sum+=eachTime+arrP[i];
			eachTime+=arrP[i];
		}
		
		System.out.println(sum);
	}
}
