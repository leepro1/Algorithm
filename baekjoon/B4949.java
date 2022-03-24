package baekjoon;

import java.util.Scanner;

public class B4949 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int cnt;
	
		while(true) {
			String str=sc.nextLine();
			if(str.equals("."))
				break;
			cnt=0;
			
			int[] arr=new int[str.length()];
			
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='(' || str.charAt(i)=='[' ) {
					arr[cnt]=str.charAt(i);
					cnt++;
				}
				else if(str.charAt(i)==')') {
					if(cnt==0) {
						cnt++;
						break;
					}
					else if(arr[cnt-1]!='(')
						break;
					else
						cnt--;
				}
				else if(str.charAt(i)==']' ) {
					if(cnt==0) {
						cnt++;
						break;
					}
					else if(arr[cnt-1]!='[') {
						break;
					}
					else
						cnt--;
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
