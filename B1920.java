import java.util.Scanner;
import java.util.Arrays;

public class B1920 {
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arrN = new int[N];
		for(int i=0;i<arrN.length;i++) {
			arrN[i]=sc.nextInt();
		}
		int key;
		int M = sc.nextInt();
		for(int i=0;i<M;i++) {
			key = sc.nextInt();
			if(Arrays.asList(arrN).contains(key)) { //배열의 객체화
				System.out.println(1);
			}
			else {
				System.out.println(0);
			}
		}
		sc.close();
	}
}
