package softeer;

import java.io.*;
import java.util.*;

public class H6251 {

    static int H, K, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken()); // 높이
        K = Integer.parseInt(st.nextToken()); // 말단 업무 수
        R = Integer.parseInt(st.nextToken()); // 날짜

        // 노드의 수는 총 2^(1+H) - 1
        int N = (int) Math.pow(2, (1 + H)) - 1;
        ArrayList<Integer>[] workList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            workList[i] = new ArrayList<Integer>();
        }

        // 리프 노드의 수는 총 2^H 입력
        int leafStartIdx = (int) Math.pow(2, H) - 1;
        for (int i = 0; i < (int) Math.pow(2, H); i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                workList[leafStartIdx + i].add(Integer.parseInt(st.nextToken()));
            }
        }

        // root는 최대 몇개 처리 가능할까? -> R - H개 / 그러면 각 레벨에서는 몇개를 올려야할까? H가 하나씩 증가할 때마다 (R - H) / 2^(H-1) 개씩 올려야함
        int cntDate = 0;
        for (int i = H; i > 0; i--, cntDate++) {
            int startNode = (int) Math.pow(2, i) - 1;
            int endNode = (int) Math.pow(2, i + 1) - 2;

            for (int j = startNode; j < endNode; j += 2) {

                for (int k = 0; k <= (R - H) / (int) Math.pow(2, (i - 1)); k++) {
                    if (k >= workList[j].size())
                        break;

                    if (cntDate % 2 == 0) {
                        workList[(j - 1) / 2].add(workList[j + 1].get(k));
                        workList[(j - 1) / 2].add(workList[j].get(k));
                    } else {
                        workList[(j - 1) / 2].add(workList[j].get(k));
                        workList[(j - 1) / 2].add(workList[j + 1].get(k));
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < R - H; i++) {
            if (i >= workList[0].size())
                break;
            answer += workList[0].get(i);
        }

        System.out.println(answer);
    }
}


