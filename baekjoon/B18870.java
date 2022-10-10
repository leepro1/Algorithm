//https://www.acmicpc.net/problem/18870
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B18870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] coordinate = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			coordinate[i] = Integer.parseInt(st.nextToken());
		}

		int[] tempNum=coordinate.clone();
		Arrays.sort(tempNum);
		
		StringBuilder sb = new StringBuilder();
		
		int cnt=0;
		
		HashMap<Integer, Integer> hashmap = new HashMap<>();
   	 	
		for(int i = 0 ; i < tempNum.length ; i++) {
   	 		if(!hashmap.containsKey(tempNum[i]))
   	 			hashmap.put(tempNum[i], cnt++);
   	 	}
   	 	
   	 	for(int i = 0; i < N ; i++) {
   	 		sb.append(hashmap.get(coordinate[i])).append(" ");
   	 	}
		
		System.out.println(sb);
	}
}
