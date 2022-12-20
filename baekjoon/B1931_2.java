//https://www.acmicpc.net/problem/1931
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931_2 {
	private static class Meeting {
		int startTime;
		int endTime;

		public Meeting(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Meeting[] array = new Meeting[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			array[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(array, (o1, o2) -> {
			if (o1.endTime == o2.endTime)
				return (o1.startTime - o2.startTime);
			else
				return (o1.endTime - o2.endTime);
		});

		int count = 0;
		int tempEndTime = 0;
		
		for (int i = 0; i < n; i++) {
			if (tempEndTime <= array[i].startTime) {
				tempEndTime = array[i].endTime;
				count++;
			}
		}
	
		System.out.println(count);
	}
}
