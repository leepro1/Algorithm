package programmers;

class P42842 {
    public int[] solution(int brown, int yellow) {
        
        int width = 0;
        int length = 0;
        int limit = brown + yellow;
        
        for(int i = 1; i <= Math.sqrt(limit); i++) {
            
            if(limit % i == 0) {
                width = i;
                length = limit / width;
                
                if(2 * width + 2 * (length - 2) == brown)
                    break;
            }
        }
        
        int[] answer = new int[] {length, width};
        return answer;
    }
}
