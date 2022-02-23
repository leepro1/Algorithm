import java.util.Scanner;

public class B2884 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		int totalM = H*60 + M;
		int setM;
		if(totalM - 45 < 0) {
			setM = (23*60) + (60+totalM-45);
		}
		else {
			setM = totalM -45; 
		}
		System.out.println(setM/60+" "+setM%60);
		
		sc.close();
	}
}
