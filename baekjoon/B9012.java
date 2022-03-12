package baekjoon;

import java.util.Scanner;

public class B9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		String ps;
		int cnt;
		
		for(int i=0;i<n;i++) {
			ps=sc.next();
			cnt=0;
			for(int j=0;j<ps.length();j++) {
				if(ps.charAt(j)=='(')
					cnt++;
				else if(ps.charAt(j)==')') {
					cnt--;
					if(cnt<0)
						break;
				}
			}
			if(cnt==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}
}
