package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H6250 {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static Node[][] scoreArr;

    static class Node implements Comparable<Node> {
        int index, score;

        Node(int index, int score) {
            this.index = index;
            this.score = score;
        }

        @Override
        public int compareTo(Node o) {
            return o.score - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

       scoreArr = new Node[4][n];

        StringTokenizer st;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                if(i == 0)
                    scoreArr[3][j] = new Node(j, 0);

                scoreArr[i][j] = new Node(j, Integer.parseInt(st.nextToken()));
                scoreArr[3][j].score += scoreArr[i][j].score;
            }
            Arrays.sort(scoreArr[i]);
            writeRank(i);
            if(i == 2) {
                Arrays.sort(scoreArr[3]);
                writeRank(3);
            }
        }

        System.out.println(sb);
    }
    private static void writeRank(int i) {
        int[] rank = new int[n];
        rank[scoreArr[i][0].index] = 1;
        for (int j = 1; j < n; j++) {
            if(scoreArr[i][j].score < scoreArr[i][j - 1].score)
                rank[scoreArr[i][j].index] = j + 1;
            else
                rank[scoreArr[i][j].index] = rank[scoreArr[i][j - 1].index];
        }

        for (int j = 0; j < n; j++) {
            sb.append(rank[j]).append(" ");
        }
        sb.append("\n");
    }
}