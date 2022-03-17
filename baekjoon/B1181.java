package baekjoon;

//sort()는 사전순 정렬이므로 글자수 정렬은 comparator를 구현해야한다.

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class B1181 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N=sc.nextInt();
		String[] str=new String[N];
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<N;i++) 
			str[i]=sc.next();
		
		//Arrays.sort(arr, new Comparator<>) - 기본인자 2개
		Arrays.sort(str,new Comparator<String>() {
			@Override
			public int compare(String e1,String e2) { //정렬의 기준을 정의
				if(e1.length()==e2.length())
					return e1.compareTo(e2);
				else
					return e1.length()-e2.length();
			}
		});
		sb.append(str[0]+"\n");
		for(int i=1; i<str.length;i++) {
			if(!str[i].equals(str[i-1]))
				sb.append(str[i]+"\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
