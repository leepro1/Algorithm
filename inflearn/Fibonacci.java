package inflearn;
/*
 재귀로 구현 - 탑다운방식
(N이 작을수록)함수호출이 불필요할 정도로 많아짐
f(4) f(3) 계산한 후 f(3) f(2)를 또 계산 - f(3)계산을 잊어버리고 다시한거임 
O(N)이 지수함수
*/
import java.util.Scanner;

public class Fibonacci {
	private static int fibonacci(int n) {
		if(n==0) return 0; //return 하면 거기서 끝
		if(n==1) return 1; //따라서 else 필요없음
		return fibonacci(n-1)+fibonacci(n-2);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		System.out.println(fibonacci(N));
		sc.close();
	}
}
