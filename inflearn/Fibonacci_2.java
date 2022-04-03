package inflearn;
/*
메모이제이션,재귀로 구현
O(N)시간
*/
import java.util.Scanner;

public class Fibonacci_2 {
	static int[] dp = new int[1000];
	private static int fibonacci(int n){
    	if(n == 0) return 0;
        if(n == 1) return 1;
        if(dp[n] != 0) return dp[n]; //dp[n]을 했던적이 있는지 확인
        dp[n] = fibonacci(n - 2) + fibonacci(n - 1);
        return dp[n];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(fibonacci(N));
        sc.close();
    }
}
