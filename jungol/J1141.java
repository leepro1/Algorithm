package jungol;

//수행시간:237ms       메모리:43.3MB
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class J1141 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();// 현재의 소를 볼 수 있는 소를 저장하는 스택
		int inputCow;
		int sum = 0; // 해당 소를 볼 수 있는 소들의 수를 더한다.
		for (int i = 0; i < n; i++) {
			inputCow = Integer.parseInt(br.readLine());

			while (true) {
				if (stack.isEmpty() || stack.peek() > inputCow) {
					stack.push(inputCow);
					break;
				}

				stack.pop();
			}

			sum += stack.size() - 1;
		}

		System.out.println(sum);
	}
}
