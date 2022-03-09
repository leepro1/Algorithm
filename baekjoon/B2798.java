package baekjoon;

import java.util.Scanner;

public class B2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //카드의 개수
		int M = sc.nextInt(); //목표 
		int[] card = new int[N]; //입력받은 카드의 수들을 담는 배열
		int[] sum = new int[N*(N-1)*(N-2)]; //N장중 3장을 뽑아 더한 수들을 담는 배열
		int answer=0; //M이하의 가장 큰 수를 담을 변수
		for(int i=0;i<N;i++) {
			card[i]=sc.nextInt();
		}
		for(int i=0;i<N-2;i++) {
			for(int j=i+1;j<N-1;j++) {
				for(int k=j+1;k<N;k++) {
					sum[i+j+k-2]=card[i]+card[j]+card[k];
					if(sum[i+j+k-2]<=M && sum[i+j+k-2]>answer) {
						answer=sum[i+j+k-2];
					}
				}
			}
		}
		System.out.println(answer);
		sc.close();
	}
}
