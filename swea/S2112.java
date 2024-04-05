import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2112 {

    static int D, W, K, answer;
    static boolean[][] map;
    static int[] paint; // 조합 결과
    static boolean[] checkType; // subset 결과
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());


            map = new boolean[D][W];

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    if (st.nextToken().equals("1"))
                        map[i][j] = true;
                }
            }

            answer = K;
            flag = false;
            for (int i = 0; i < K; i++) {
                paint = new int[i];
                combination(0, 0, i);
                if (flag)
                    break;
            }
            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    static boolean combination(int start, int depth, int limit) {
        if (depth == limit) {
            checkType = new boolean[limit];
            subset(0);

            return flag;
        }

        for (int i = start; i < D; i++) {
            paint[depth] = i;
            if(combination(i + 1, depth + 1, limit))
                return flag;
        }
        return flag;
    }

    static boolean subset(int depth) {
        if (depth == checkType.length) {
            if (check()) {
                answer = Math.min(answer, checkType.length);
                flag = true;
            }
            return flag;
        }

        checkType[depth] = true;
        if (subset(depth + 1))
            return flag;

        checkType[depth] = false;
        subset(depth + 1);

        return flag;
    }

    static boolean check() {
        boolean[][] tempMap = new boolean[D][W];

        for (int i = 0; i < D; i++) {
            for (int j = 0; j < W; j++) {
                tempMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < paint.length; i++) {
            if (checkType[i]) {
                for (int j = 0; j < W; j++) {
                    tempMap[paint[i]][j] = true;
                }
            } else {
                for (int j = 0; j < W; j++) {
                    tempMap[paint[i]][j] = false;
                }
            }
        }

        if (countResult(tempMap)) return true;

        return false;
    }

    private static boolean countResult(boolean[][] tempMap) {
        for (int i = 0; i < W; i++) {
            int tempCnt = K - 1;
            for (int j = 1; j < D; j++) {
                if (tempMap[j][i] == tempMap[j - 1][i])
                    tempCnt--;
                else
                    tempCnt = K - 1;

                if (tempCnt <= 0)
                    break;
            }

            if (tempCnt > 0)
                return false;
        }
        return true;
    }
}
