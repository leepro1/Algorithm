import java.util.Scanner;

public class B2475 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num;
		int sum=0; 
		for(int i=0; i<6; i++){
			num = sc.nextInt();
			sum+=num*num;
		}
		System.out.println(sum%10);
		sc.close();
	}
}