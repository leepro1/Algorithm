//https://www.acmicpc.net/problem/5525
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5525 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int M=Integer.parseInt(br.readLine());
		String S=br.readLine();
		
		int answerCnt=0;
		int nCnt=0;
		int plusCnt=0;
		
		for(int i=0;i<M-1;i++) {
            if(S.charAt(i)=='I' && S.charAt(i+1)=='O') {
            	nCnt++;
                
                if(nCnt>=N) {
                    if(S.charAt(i+2)=='I') {
                    	answerCnt++;
                    	plusCnt++;
                    }
                    else {
                    	nCnt=0;
                    	answerCnt+=plusCnt;
                    	plusCnt=0;
                    }
                }
                i++;
            }
            else {
            	nCnt=0;
            }
        }
        System.out.println(answerCnt);
    }
}
