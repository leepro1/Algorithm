package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1244 {
	static int max, swapCnt;
	static char[] str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			str = st.nextToken().toCharArray();
			swapCnt = Integer.parseInt(st.nextToken());

			if(str.length<swapCnt) {
				swapCnt=str.length;
			}
			
			max = 0;
			dfs(0);
			
			sb.append("#" + t + " " + max + "\n");
		}
		System.out.println(sb);
	}

	static void dfs(int depth) {
		if (depth == swapCnt) {
			String tempStr=new String(str);
			max=Math.max(max,Integer.parseInt(tempStr));
			return;
		}

		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1; j < str.length; j++) {
				swap(i, j);
				dfs(depth + 1);
				swap(i, j);
			}
		}
	}

	static void swap(int i, int j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}
}
