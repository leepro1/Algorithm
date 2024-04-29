package programmers;

import java.util.*;

class P42746 {
    public String solution(int[] numbers) {
      	String[] numbersAsString = new String[numbers.length];

        for (int i = 0; i < numbersAsString.length; i++) {
            numbersAsString[i] = String.valueOf(numbers[i]);
        }

		Arrays.sort(numbersAsString, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

		StringBuilder answer = new StringBuilder();
		for (int i = 0, size = numbersAsString.length; i < size; i++) {
			if (answer.length() == 0 && numbersAsString[i].equals("0"))
				continue;

			answer.append(numbersAsString[i]);
		}

		if(answer.length() == 0)
			return "0";
        
		return answer.toString();
    }
}
