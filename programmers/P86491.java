package programmers;

public class P86491 {
    public int solution(int[][] sizes) {
        int w = 0;
        int h = 0;

        for (int i = 0, size = sizes.length; i < size; i++) {
            int tempW = Math.min(sizes[i][0], sizes[i][1]);
            int tempH = Math.max(sizes[i][0], sizes[i][1]);

            w = Math.max(w, tempW);
            h = Math.max(h, tempH);
        }

        return w * h;
    }
}
