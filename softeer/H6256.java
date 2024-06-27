package softeer;

import java.io.*;
import java.util.*;

public class H6256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] carInfo = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            carInfo[i][0] = Integer.parseInt(st.nextToken());
            carInfo[i][1] = st.nextToken().charAt(0) - 'A';
            carInfo[i][2] = -1;
        }

        // 교차로 배열 (A, B, C, D 순)
        LinkedList<Integer>[] crossInfo = new LinkedList[4];
        for (int i = 0; i < 4; i++) {
            crossInfo[i] = new LinkedList<>();
        }

        // 시간초를 세면서 1. 교차로에 넣기 2. 교차로가 차가 있으면 out 하기
        int time = carInfo[0][0];
        int index = 0;
        int restCar = 0;
        while (restCar >= 0) {

            // 차량 넣기
            while (index < N) {
                if (time == carInfo[index][0]) {
                    crossInfo[carInfo[index][1]].add(index);
                    restCar++;
                    index++;

                    // 모든 차량을 넣었을 때
                    if (index == N) {
                        restCar--;
                    }
                } else {
                    break;
                }
            }
            if(index != N && restCar == 0) {
                time = carInfo[index][0];
                continue;
            }

            // 도로 검사
            boolean[] canOut = new boolean[4];
            for (int i = 0; i < 4; i++) {
                if (!crossInfo[i].isEmpty() && crossInfo[(i + 3) % 4].isEmpty()) {
                    canOut[i] = true;
                }
            }

            // 병목 체크
            if (!crossInfo[0].isEmpty() && !crossInfo[1].isEmpty() && !crossInfo[2].isEmpty() && !crossInfo[3].isEmpty()) {
                break;
            }

            // out
            for (int i = 0; i < 4; i++) {
                if (canOut[i]) {
                    carInfo[crossInfo[i].remove()][2] = time;
                    restCar--;
                }
            }

            time++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(carInfo[i][2]).append("\n");
        }

        System.out.println(sb);
    }
}
