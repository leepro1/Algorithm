import java.util.Scanner;

public class B2920 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		String scaleStr = "";
		int[] D = new int[8];
		for(int i=0;i<8;i++) {
			D[i] = sc.nextInt();
		}
		for(int i=0;i<7;i++) {
			if(D[i+1]==D[i]+1) {
				scaleStr = "ascending";
			}
			else if(D[i+1]==D[i]-1) {
				scaleStr = "descending";
			}
			else {
				scaleStr = "mixed";
				break;
			}
		}
		
		System.out.println(scaleStr);
		
		sc.close();
	}
}
