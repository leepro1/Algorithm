package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1967 {

    static int N;
    static ArrayList<Node>[] nodeList;

    static class Node {

        int child;
        int cost;

        Node(int child, int cost) {
            this.child = child;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nodeList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodeList[parent].add(new Node(child, cost));
        }

        int answer = 0;
        int[] maxDist = new int[N + 1];
        for (int i = N; i > 0; i--) {
            if (nodeList[i].isEmpty()) {
                continue;
            } else if (nodeList[i].size() == 1) {
                maxDist[i] = maxDist[nodeList[i].get(0).child] + nodeList[i].get(0).cost;
            } else {
                int[] temp = new int[nodeList[i].size()];
                for (int j = 0; j < nodeList[i].size(); j++) {
                    temp[j] = maxDist[nodeList[i].get(j).child] + nodeList[i].get(j).cost;
                    maxDist[i] = Math.max(maxDist[i], temp[j]);
                }
                Arrays.sort(temp);
                answer = Math.max(answer, temp[nodeList[i].size() - 1] + temp[nodeList[i].size() - 2]);
            }
        }

        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, maxDist[i]);
        }

        System.out.println(answer);
    }

}
