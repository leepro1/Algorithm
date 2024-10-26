import java.util.*;

class P42860 {
    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;

        for(int i = 0; i < name.length(); i++) {
            char target = name.charAt(i);

            // 위아래 이동 계산 (알파벳 변경)
            if(target != 'A') {
                answer += Math.min(target - 'A', 'Z' - target + 1);
            }

            // 좌우 이동 최소화
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i * 2 + name.length() - next);
            move = Math.min(move, (name.length() - next) * 2 + i);
        }

        return answer + move;
    }
}
