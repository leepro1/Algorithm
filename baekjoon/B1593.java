package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1593 {

    static int g;
    static int s;
    static String G;
    static String S;

    static int answer;
    static char[] subStr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        g = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        G = br.readLine();
        S = br.readLine();

        subStr = new char[g];
        visited = new boolean[g];

        permutation(0);

        System.out.println(answer);
    }

    static void permutation(int depth) {
        if (depth == g) {
            if (S.contains(String.valueOf(subStr)))
                answer++;
            return;
        }

        for (int i = 0; i < g; i++) {

            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            subStr[depth] = G.charAt(i);
            permutation(depth + 1);
            visited[i] = false;

        }

    }

}
