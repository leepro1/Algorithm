package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class H6283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int temp = Integer.parseInt(st.nextToken());
        String str = "mixed";
        if (temp == 1) {
            str = "ascending";
        } else if (temp == 8) {
            str = "descending";
        } else {
            System.out.println(str);
            return;

        }

        for (int i = 2; i <= 8; i++) {
            int now = Integer.parseInt(st.nextToken());
            if (str.equals("ascending") && now == i) {
                continue;
            } else if (str.equals("descending") && now == 8 - i + 1) {
                continue;
            } else {
                str = "mixed";
                break;
            }
        }

        System.out.println(str);
    }
}
