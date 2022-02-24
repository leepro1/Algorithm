import java.util.Scanner;

public class B10951 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int A=sc.nextInt();
			int B=sc.nextInt();
			System.out.println(A+B);
		}
		sc.close();
	}
}
