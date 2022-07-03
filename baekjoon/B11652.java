//https://www.acmicpc.net/problem/11652
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

public class B11652 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> map=new HashMap<>();
		int max=0;
		
		while(N-->0) {
			int inputNum=Integer.parseInt(br.readLine());
			
			if(!map.containsKey(inputNum)) {
				map.put(inputNum, 1);
			}
			else {
				map.replace(inputNum, map.get(inputNum)+1);
				if(map.get(inputNum)>max) {
					max=map.get(inputNum);
				}
			}
		}
		
		TreeMap<Integer,Integer> sortedMap = new TreeMap<>(map);
		
		for(Integer keys : sortedMap.keySet()){
			if(max==sortedMap.get(keys)){
				System.out.println(keys);
				break;
			
			}
		}
	}
}
