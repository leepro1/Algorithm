package programmers;

import java.util.*;

class P42840 {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        int cntA = 0;
        int cntB = 0;
        int cntC = 0;
        
        for(int i=0, size = answers.length; i<size; i++){
            if(a[i%5]==answers[i])
                cntA++;
            
            if(b[i%8]==answers[i])
                cntB++;
            
            if(c[i%10]==answers[i])
                cntC++;
        }
        
        // max 설정
        int max = cntA;
        if(max<cntB)
            max = cntB;
        
        if(max<cntC)
            max = cntC;
    
        // 배열 추가
        if(max == cntA)
            answer.add(1);
    
        if(max == cntB)
            answer.add(2);
        
        if(max == cntC)
            answer.add(3);
            
        int[] realAnswer = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            realAnswer[i] = answer.get(i);
        }
        
        return realAnswer;
    }
}