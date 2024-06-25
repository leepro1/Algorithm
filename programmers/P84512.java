package programmers;

class P84512 {
    public int solution(String word) {
        int answer = word.length();
        
        // f(x) = f(x - 1) + 5^x
        int[] increase = {781, 156, 31, 6, 1};
        
        for(int i = 1, size = word.length(); i <= size; i++) {
            
            switch (word.charAt(size - i)) {
                case 'A':
                    break;
                case 'E':
                    answer += increase[size - i];
                    break;
                case 'I':
                    answer += increase[size - i] * 2;
                    break;
                case 'O':
                    answer += increase[size - i] * 3;
                    break;
                case 'U':
                    answer += increase[size - i] * 4;
                    break;
            }
        }
        
        return answer;
    }
}
