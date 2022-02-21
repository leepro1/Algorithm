import java.util.Scanner;

public class B1008 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		double result = (double)A/(double)B;
		System.out.println(result);
		sc.close();
	}
}
