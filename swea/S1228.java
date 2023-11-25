package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S1228 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		int originN, orderN, indexN, insertN;
		LinkedList<Integer> list;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			originN = Integer.parseInt(br.readLine());

			list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			while (originN-- > 0) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			orderN = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while (orderN-- > 0) {
				if("I".equals(st.nextToken())) {
					indexN = Integer.parseInt(st.nextToken());
					insertN = Integer.parseInt(st.nextToken());
					
					for(int i=0;i<insertN;i++) {
						list.add(indexN,Integer.parseInt(st.nextToken()));
						indexN++;
					}
				}
			}

			sb.append("#" + t);

			for (int i = 0; i < 10; i++) {
				sb.append(" " + list.remove());
			}

			sb.append("\n");
		}
		System.out.println(sb);
	}
}
