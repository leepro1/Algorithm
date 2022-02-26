import java.util.Scanner;

public class B1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N,M,reverseN;
		
		while(true) {
			N=sc.nextInt();
			M=N;
			reverseN = 0;
			if(N==0) {
				break;
			}
			else {
				while(N>0) {
					reverseN*=10;
					reverseN+=(N%10);
					N/=10;
				}
				if(reverseN==M) {
					System.out.println("yes");
				}
				else {
					System.out.println("no");
				}
			}
		}
		sc.close();
	}
}
