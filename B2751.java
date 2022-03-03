import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class B2751 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) {
			list.add(sc.nextInt());
		}
		
		Collections.sort(list); //Arrays.sort(arr) 을 사용하면 시간초과. 
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(list.get(i)+"\n");
		}
		
		System.out.println(sb);
		
		sc.close();
	}
}
