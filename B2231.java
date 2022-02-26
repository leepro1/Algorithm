import java.util.Scanner;

public class B2231 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt(); //분해합
		int M = 0; //생성자
		int j; //N이하 자연수의 생성자
		for(int i=1;i<N;i++) {
			j=i;
			for(int k=i;k>0;k/=10) {
				j+=k%10;
			}
			if(j==N) {
				M=i;
				break;
			}
		}
		System.out.println(M);
		sc.close();
	}
}
