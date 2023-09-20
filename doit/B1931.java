/*
 * https://www.acmicpc.net/problem/1931
 * 회의실 배정
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1931 {
	static class MeetingInfo {
		int startTime;
		int endTime;

		MeetingInfo(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<MeetingInfo> pq = new PriorityQueue<>((MeetingInfo a, MeetingInfo b) -> {
			if (a.endTime == b.endTime)
				return a.startTime - b.startTime;
			return a.endTime - b.endTime;
		});

		StringTokenizer st;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());

			pq.offer(new MeetingInfo(startTime, endTime));
		}

		int cnt = 0;
		int nowEndTime = 0;
		while (!pq.isEmpty()) {
			MeetingInfo nextMeetingInfo = pq.poll();
			if (nowEndTime <= nextMeetingInfo.startTime) {
				nowEndTime = nextMeetingInfo.endTime;
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
