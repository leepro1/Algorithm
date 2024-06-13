package goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class G194982 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 집의 개수
        int M = Integer.parseInt(st.nextToken()); // 장마 일수

        st = new StringTokenizer(br.readLine());
        int[] house = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> visited = new HashSet<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int j = start; j <= end; j++) {
                house[j]++;
                visited.add(j);
            }

            if (i % 3 == 0) {
                Iterator iter = visited.iterator();

                while(iter.hasNext()) {
                    house[(int)iter.next()]--;
                }

                visited.clear();
            }
        }

        for (int h = 1; h <= N; h++) {
            System.out.print(house[h] + " ");
        }
    }
}
