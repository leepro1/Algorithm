package softeer;

import java.io.*;
import java.util.*;

public class H6255 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine();
        String key = br.readLine();

        boolean[] visited = new boolean[26];
        ArrayList<Character> keyArr = new ArrayList<>();

        for(int i = 0; i < key.length(); i++) {
            if(visited[key.charAt(i) - 'A'])
                continue;

            keyArr.add(key.charAt(i));
            visited[key.charAt(i) - 'A'] = true;
        }

        for(int i = 0; i < 26; i++) {
            if(visited[i] || i == 'J' - 'A')
                continue;

            keyArr.add((char)('A' + i));
        }

        StringBuilder msgSb = new StringBuilder(msg);
        for(int i = 0; i < msgSb.length(); i += 2) {
            if(i + 1 == msgSb.length()) {
                msgSb.append("X");
                break;
            }

            if(msgSb.charAt(i) == msgSb.charAt(i + 1)) {
                if(msgSb.charAt(i) == 'X')
                    msgSb.insert(i + 1, 'Q');
                else
                    msgSb.insert(i + 1, 'X');
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < msgSb.length(); i += 2) {
            int a = keyArr.indexOf(msgSb.charAt(i));
            int b = keyArr.indexOf(msgSb.charAt(i + 1));

            // Same row
            if(a / 5 == b / 5) {
                sb.append(keyArr.get(a / 5 * 5 + (a + 1) % 5));
                sb.append(keyArr.get(b / 5 * 5 + (b + 1) % 5));
            }
            // Same column
            else if(a % 5 == b % 5) {
                sb.append(keyArr.get((a + 5) % 25));
                sb.append(keyArr.get((b + 5) % 25));
            }
            // Rectangle
            else {
                sb.append(keyArr.get(a / 5 * 5 + b % 5));
                sb.append(keyArr.get(b / 5 * 5 + a % 5));
            }
        }

        System.out.println(sb.toString());
    }
}
