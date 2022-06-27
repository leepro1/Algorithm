//https://www.acmicpc.net/problem/9375
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		HashMap<String,String> map=new HashMap<>();
		
		for(int i=0;i<T;i++) {
			int n=Integer.parseInt(br.readLine());
			ArrayList<String> valueArray=new ArrayList<>();
			ArrayList<Integer> cntArray=new ArrayList<>();
			
			for(int j=0;j<n;j++) {
				st=new StringTokenizer(br.readLine());
				String key=st.nextToken();
				String value=st.nextToken();
				if(j==0) {
					map.put(key, value);
					valueArray.add(value);
					cntArray.add(1);
				}
				else {
					if(map.containsValue(value)) {
						int index=valueArray.indexOf(value);
						cntArray.set(index, cntArray.get(index)+1);
					}
					else {
						valueArray.add(value);
						cntArray.add(1);
					}
					map.put(key, value);
				}
			}
			int totalCase=1;
			
			for(int k=0;k<cntArray.size();k++) {
				totalCase*=cntArray.get(k)+1;
			}
			System.out.println(totalCase-1);
			map.clear();
		}
	}

}
