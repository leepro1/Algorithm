package baekjoon;

import java.util.Date;
import java.text.SimpleDateFormat;

public class B10699 {
	public static void main(String[] args) {
		Date today = new Date();
		// System.out.println(today); Fri Feb 18 18:05:20 KST 2022
		SimpleDateFormat formatToday = new SimpleDateFormat("YYYY-MM-dd"); //소문자 mm은 분(minute)
		System.out.println(formatToday.format(today)); //2022-02-18

	}
}
