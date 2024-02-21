package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J2247 {
	static class library implements Comparable<library> {
		int start;
		int end;

		library(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(library o) {
			return this.start == o.start ? o.end - this.end : this.start - o.start;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		library[] timeTable = new library[N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			timeTable[i] = new library(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(timeTable);
	
		int startTime = timeTable[0].start;
		int endTime = timeTable[0].end;
		int stayTime = 0;
		int unstayTime = 0;
		for (int i = 1; i < N; i++) {
			if (timeTable[i].end <= endTime)
				continue;

			if (timeTable[i].start <= endTime) {
				endTime = timeTable[i].end;
				stayTime = Math.max(stayTime, endTime - startTime);
			}

			else {
				unstayTime = Math.max(unstayTime, timeTable[i].start - endTime);
				startTime = timeTable[i].start;
				endTime = timeTable[i].end;
			}
		}
		System.out.println(stayTime + " " + unstayTime);
	}
}
