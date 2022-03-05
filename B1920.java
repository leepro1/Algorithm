import java.util.Scanner;
import java.util.stream.IntStream;

public class B1920 {
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arrN = new int[N];
		for(int i=0;i<arrN.length;i++) {
			arrN[i]=sc.nextInt();
		}
		
		int M = sc.nextInt();
		for(int i=0;i<M;i++) {
			int key = sc.nextInt();
			if(IntStream.of(arrN).anyMatch(x -> x == key)) {
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
		sc.close();
	}
}
