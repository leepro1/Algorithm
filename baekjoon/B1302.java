//https://www.acmicpc.net/problem/1302
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class B1302 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		TreeMap<String,Integer> map=new TreeMap<>();
		
		while(N-->0) {
			String str=br.readLine();
			if(!map.containsKey(str)) {
				map.put(str,1);
			}
			else {
				map.replace(str,map.get(str)+1);
			}
		}

		int max = 0;
		for(String a : map.keySet()){
			max = Math.max(max, map.get(a));
		}
		
		 ArrayList<String> list = new ArrayList<String>(map.keySet());
		 for(String book : list){
	            if(map.get(book)==max){
	                System.out.println(book);
	                break;
	            }
		 }
	}
}
