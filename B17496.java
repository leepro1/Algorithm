import java.util.Scanner;

public class B17496 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //여름의 일 수
		int T = sc.nextInt(); //자라는데 걸리는 일 수
		int C = sc.nextInt(); //심을 수 있는 칸의 수
		int P = sc.nextInt(); // 개당 가격
		
		int total = (N-1) / T * C; //기간동안의 총 개수
		
		System.out.println(total * P);
		sc.close();
	}
}
