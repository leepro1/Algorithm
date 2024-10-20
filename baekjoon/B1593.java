package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1593 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int g = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        String G = br.readLine();
        String S = br.readLine();

        int[] gArr = new int[52];
        int[] sArr = new int[52];

        for (char c : G.toCharArray()) {
            putWord(c, gArr, 1);
        }

        int start = 0;
        int count = 0;
        int size = 0;
        for (int i = 0; i < S.length(); i++) {
            char sc = S.charAt(i);
            putWord(sc, sArr, 1);
            size++;

            if (size == g) {

                if (Arrays.equals(gArr, sArr)) {
                    count++;
                }

                putWord(S.charAt(start), sArr, -1);
                start++;
                size--;
            }
        }
        System.out.println(count);
    }

    static void putWord(char word, int[] arr, int dif) {
        if ('a' <= word && word <= 'z') {
            arr[word - 'a'] += dif;
        } else {
            arr[word - 'A' + 26] += dif;
        }
    }
}
