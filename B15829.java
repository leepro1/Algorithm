import java.util.Scanner;

public class B15829 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L=sc.nextInt();
		String str = sc.next();
		
		int M=1234567891;
		int n=31;
		
		long sum=0;
		long H=1;
		
		for(int i=0;i<L;i++) {
			sum+=(str.charAt(i)-'a'+1)*H;
			H=(H*n)%M;
		}
		System.out.println(sum%M);
		sc.close();
	}
}
