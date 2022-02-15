import java.util.Scanner;

public class B5522 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A;
		int sum = 0;
		for(int i=0; i<5;i++) {
			A=sc.nextInt();
			sum+=A;
		}
		System.out.println(sum);
		sc.close();
	}
}
