import java.util.Scanner;

public class B4153 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A,B,C;
		
		while(true) {
			
			A=sc.nextInt();
			B=sc.nextInt();
			C=sc.nextInt();
			
			if((A==0 && B==0 && C==0)) {
				break;
			}
			else{
				if(A*A+B*B==C*C || B*B+C*C==A*A || C*C+A*A==B*B)
					System.out.println("right");
				else {
					System.out.println("wrong");		
				}
			}
		}
		sc.close();
	}
}
