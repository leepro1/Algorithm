import java.util.Scanner;

public class B5554 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int travelTime;
		int totalTime = 0;
		for(int i=0;i<4;i++) {
			travelTime = sc.nextInt();
			totalTime += travelTime;
		}
		System.out.println(totalTime/60);
		System.out.println(totalTime%60);
		sc.close();
	}
}
