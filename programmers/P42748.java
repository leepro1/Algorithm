package programmers;

import java.util.Arrays;

public class P42748 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int t=0,size=answer.length; t<size; t++){
            int[] temp = Arrays.copyOfRange(array, commands[t][0]-1, commands[t][1]);

            Arrays.sort(temp);

            answer[t] = temp[commands[t][2]-1];
        }

        return answer;
    }
}
