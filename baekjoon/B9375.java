package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class B9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(br.readLine());
		Map<String,String> map=new HashMap<>();
		
		for(int i=0;i<T;i++) {
			int answerCnt=1;
			int n=Integer.parseInt(br.readLine());
			for(int j=0;j<n;j++) {
				st=new StringTokenizer(br.readLine());
				map.put(st.nextToken(), st.nextToken());
			}
			List<Map.Entry<String, String>> entryList = new LinkedList<>(map.entrySet());
			entryList.sort(Map.Entry.comparingByValue());
			int tempCnt=1;
			boolean flag=false;
			
			String str1=null;
			String str2=null;
			
			for(Map.Entry<String, String> entry : entryList){
				if(flag==false) {
					str1=entry.getValue();
					flag=true;
				}
				str2=entry.getValue();
				if(!str1.equals(str2)) {
					answerCnt*=tempCnt;
					tempCnt=1;
					flag=false;
				}
				tempCnt++;
			}
			System.out.println(answerCnt);
			map.clear();
		}
	}
}
