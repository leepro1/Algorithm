import java.util.Scanner;
import java.util.Arrays;

public class B11650 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr=new int[N][2];
		
		for(int i=0;i<N;i++) {
			arr[i][0]=sc.nextInt();
			arr[i][1]=sc.nextInt();
		}
		
		for(int i=0;i<N;i++) {
			System.out.println(arr[i][0]+" "+arr[i][1]);
		}
		sc.close();
	}
	public int a(int[] elm1,int[] elm2) {
		if(elm1[0]==elm2[1])
			return elm1[1]-elm2[1];
		else
			return elm1[0]-elm1[0];
	}
}
