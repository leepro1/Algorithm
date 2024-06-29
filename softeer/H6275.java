package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class H6275 {
    static int H, W;
    static boolean[][] map, visited;
    static ArrayList<Node> possibleStart = new ArrayList<>();

    static int direction;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static StringBuilder orderStr;

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new boolean[H+1][W+1];
        visited = new boolean[H+1][W+1];

        for(int i=1;i<=H;i++){
            String str = br.readLine();
            for (int j = 1; j <= W; j++) {
                if(str.charAt(j-1) == '#') {
                    map[i][j] = true;
                    possibleStart.add(new Node(i, j));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        char[] directionArr = {'>', '<', 'v', '^'};

        int answerX = 0, answerY = 0;
        char answerDirection = '>';
        StringBuilder answerStr = new StringBuilder();
        for(Node temp : possibleStart ) {

            if(!canSearch(temp))
                continue;

            searchLogic(temp);

            if(min > orderStr.length()) {
                min = orderStr.length();
                answerX = temp.x;
                answerY = temp.y;
                answerDirection = directionArr[direction];
                answerStr = orderStr;
            }

        }

        System.out.println(answerX+" "+ answerY);
        System.out.println(answerDirection);
        System.out.println(answerStr);
    }

    static private boolean canSearch(Node node) {
        int cnt = 0;

        if(node.x - 1 > 0 && map[node.x - 1][node.y])
            cnt++;

        if(node.x + 1 <= H && map[node.x + 1][node.y])
            cnt++;

        if(node.y - 1 > 0 && map[node.x][node.y - 1])
            cnt++;

        if(node.y + 1 <= W && map[node.x][node.y + 1])
            cnt++;

        return cnt == 1;
    }

    static private void searchLogic(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        boolean[][] tempVisited = visited;

    }
}
