import java.util.Scanner;

public class B3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] inputNum = new int[10];
		int[] remainNum = new int[10];
		for(int i=0;i<10;i++) {
			inputNum[i] = sc.nextInt();
			remainNum[i] = inputNum[i]%42;
		}
		int diffRemainNum = 10;
		for(int i=0;i<10;i++) {
			for(int j=1;i+j<10;j++) {
				if(remainNum[i]==remainNum[i+j]) {
					diffRemainNum--;
					break;
				}
			}
		}
		System.out.println(diffRemainNum);
		
		sc.close();
	}
}
