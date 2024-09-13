package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16509 {

    static int ex, ey;
    static int kx, ky;
    static int answer = -1;
    static boolean[][] visited = new boolean[10][9];

    static int[] dx = {-3, -3, -2, -2, 2, 2, 3, 3};
    static int[] dy = {-2, 2, -3, 3, -3, 3, -2, 2};

    static int[] no1x = {-1, -1, 0, 0, 0, 0, 1, 1};
    static int[] no1y = {0, 0, -1, 1, -1, 1, 0, 0};

    static int[] no2x = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] no2y = {-1, 1, -2, 2, -2, 2, -1, 1};

    static class Rock {

        int x, y, cnt;

        public Rock(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        kx = Integer.parseInt(st.nextToken());
        ky = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(answer);
    }

    static void bfs() {
        Queue<Rock> queue = new ArrayDeque<>();
        queue.add(new Rock(ex, ey, 0));
        visited[ex][ey] = true;

        while (!queue.isEmpty()) {
            Rock rock = queue.poll();

            if (rock.x == kx && rock.y == ky) {
                answer = rock.cnt;
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = rock.x + dx[i];
                int ny = rock.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= 10 || ny >= 9 || visited[nx][ny]) {
                    continue;
                }

                if (rock.x + no1x[i] == kx && rock.y + no1y[i] == ky) {
                    continue;
                }

                if (rock.x + no2x[i] == kx && rock.y + no2y[i] == ky) {
                    continue;
                }

                queue.add(new Rock(nx, ny, rock.cnt + 1));
                visited[nx][ny] = true;

            }
        }

    }
}
