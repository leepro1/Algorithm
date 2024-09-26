package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1897 {

    static int d;
    static String start;
    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        d = Integer.parseInt(st.nextToken());
        start = st.nextToken();

        words = new String[d];
        for (int i = 0; i < d; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, Comparator.comparingInt(String::length));

        ArrayList[] list = new ArrayList[2];
        list[0] = new ArrayList<String>(); // 짝수 문자열 저장
        list[1] = new ArrayList<String>();

        list[1].add(start);
        int length = 4;
        for (int i = 0; i < d; i++) {

            if (words[i].length() < length) {
                continue;
            } else if (words[i].length() == length + 1) {

                if (list[length % 2].isEmpty()) {
                    break;
                }

                list[(length - 1) % 2] = new ArrayList<String>();
                length++;
            }

            if (words[i].length() == length) {

                for (Object str : list[(length - 1) % 2]) {
                    if (checkWord((String) str, words[i])) {
                        list[length % 2].add(words[i]);
                        break;
                    }
                }
            } else {
                break;
            }

        }

        if (list[length % 2].isEmpty()) {
            System.out.println(list[(length - 1) % 2].get(0));
        } else {
            System.out.println(list[length % 2].get(0));
        }

    }

    static boolean checkWord(String pre, String now) {

        int flag = 0;

        for (int i = 0; i < now.length(); i++) {

            if (now.charAt(i) != pre.charAt(i - flag)) {
                flag++;
            }

            if (flag > 1) {
                return false;
            }

            if (i == pre.length() - 1 && flag == 0) {
                return true;
            }
        }

        return true;
    }
}
