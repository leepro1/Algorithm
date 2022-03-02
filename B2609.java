import java.util.Scanner;

public class B2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A=sc.nextInt();
		int B=sc.nextInt();
		int gcd,lcm; //gcd는 최대공약수, lcm은 최소공배수
		gcd = reFuncGcd(A,B);
		lcm = (A*B)/gcd;
		
		System.out.println(gcd);
		System.out.println(lcm);
		
	}
	public static int reFuncGcd(int a, int b) { //최대공약수를 구하는 재귀함수
		if(b==0)
			return a;
		return reFuncGcd(b,a%b);
	}
	
}
