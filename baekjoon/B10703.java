import baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10703 {

    static int R, S;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        map = new char[R + 1][S];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < S; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 거리 구하기
        int dist = R;
        for (int i = 0; i < S; i++) {
            int tempDist = R;
            int lastX = -1;

            for (int j = 0; j < R; j++) {
                if (map[j][i] == 'X') {
                    lastX = j;
                } else if (map[j][i] == '#') {
                    if (lastX != -1) {
                        tempDist = Math.min(tempDist, j - lastX - 1);
                    }
                    map[R][i] = (char) (lastX + '0');
                    break;
                }
            }
            dist = Math.min(dist, tempDist);
        }

        // 수직 낙하
        for (int i = 0; i < S; i++) {

            if (map[R][i] - '0' == -1) {
                continue;
            }

            for (int j = map[R][i] - '0' + dist; j >= dist; j--) {
                map[j][i] = map[j - dist][i];
            }

            for (int j = 0; j < dist; j++) {
                map[j][i] = '.';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
