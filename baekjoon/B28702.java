package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B28702 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = new String[3];

        int nextNum = 0;
        for (int i = 0; i < 3; i++) {
            strArr[i] = br.readLine();

            if(!strArr[i].equals("FizzBuzz") && !strArr[i].equals("Fizz") && !strArr[i].equals("Buzz")) {
                nextNum = Integer.parseInt(strArr[i]) + (3 - i);
            }
        }

        if(nextNum % 3 == 0 && nextNum % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (nextNum % 5 == 0) {
            System.out.println("Buzz");
        } else if (nextNum % 3 == 0) {
            System.out.println("Fizz");
        } else {
            System.out.println(nextNum);
        }

    }
}
