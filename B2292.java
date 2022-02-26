import java.util.Scanner;

public class B2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int roomLevel = 1; //최소칸수
		int k=1; //최소칸수를 구하기 위한 점화계수
		for(int i=1;k<N;i++) {
			roomLevel++;
			k+=i*6;
		}
		System.out.println(roomLevel);
		sc.close();
	}
}
