package baekjoon;

import java.time.LocalDate; //after java8 

public class B16170 {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		
		System.out.println(now.getYear());
		System.out.println(now.getMonth().getValue());
		System.out.println(now.getDayOfMonth());
	}
}
