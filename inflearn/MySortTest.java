package inflearn;
//사용자가 원하는 개수의 학번을 입력받아 소속 - 입학년도 - 번호 순으로 오름차순 정렬하는 프로그램을 작성하세요.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MySortTest {
	public static void shellSort(String[] arr) {
		int i,j;
		String item;
		for(int h=arr.length/2;h>0;h/=2) { //간격 h를 기준으로 부분집합을 만들어 삽입정렬사용(=셸정렬)
			for(i=h;i<arr.length;i++) {
				item=arr[i];
				for(j=i-h;j>=0 && swapChecker(arr[j],item);j-=h) //자료를 정렬하는 key값이 3개라 swapChecker사용
					arr[j+h]=arr[j];
				arr[j+h]=item;
			}
		}
	}
	
	public static boolean swapChecker(String a,String b) { //key값을 중심으로 재배열해야 할 때 true 리턴
		if(Integer.parseInt(a.substring(4,6))>Integer.parseInt(b.substring(4,6))) //key값이 학번
			return true;
		else if(Integer.parseInt(a.substring(4,6))==Integer.parseInt(b.substring(4,6))) {
			if(Integer.parseInt(a.substring(0,4))>Integer.parseInt(b.substring(0,4))) //key값이 입학년도
				return true;
			else if(Integer.parseInt(a.substring(0,4))==Integer.parseInt(b.substring(0,4))) {
				if(Integer.parseInt(a.substring(6))>Integer.parseInt(b.substring(6))) //key값이 번호
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println("hw11_1 : 이희주");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine()); //자료의 개수를 입력받는다.
		String[] studentId=new String[n]; //학번을 저장할 String형 배열 선언
		
		for(int i=0;i<n;i++) {
			String input=br.readLine(); //한줄씩 입력받는다.
			if(input.length()==7) //7자리인(2000년도 전) 학번은 정렬의 편의성을 위해 9자리로 바꾸어저장
				input="19"+input;
			studentId[i]=(input);
		}
		
		shellSort(studentId); //셸 정렬을 사용하였다.
		
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<n;i++) {
			if(studentId[i].charAt(0)=='1') {
				sb.append(studentId[i].substring(2)).append("\n"); //7자리였던(2000년도 전) 학번을 다시 7자리로 바꾸어 추가
				continue;
			}
			sb.append(studentId[i]).append("\n");
		}
		System.out.println(sb);
	}
}
