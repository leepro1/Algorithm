import java.util.Scanner;

public class B2845 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int articlePeople;
		int L = sc.nextInt();
		int P = sc.nextInt();
		int[] dif = new int[5]; //L*P==»ç¶÷ ¼ö
		for(int i=0; i<5; i++) {
			articlePeople = sc.nextInt();
			dif[i] = articlePeople - L * P;
		}
		for(int i=0; i<dif.length; i++) {
			System.out.println(dif[i]);
		}
		sc.close();
	}
}
