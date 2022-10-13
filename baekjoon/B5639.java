//https://www.acmicpc.net/problem/5639
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5639 {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Node root = new Node();

		try {
			root = new Node(Integer.parseInt(br.readLine()));

			while (true) {
				String str = br.readLine();

				root.insert(Integer.parseInt(str));
			}

		} catch (NumberFormatException e) {

		} finally {
			postorder(root);
			System.out.println(sb);

		}
	}

	private static class Node {
		int key;
		Node left, right;

		Node() {}

		Node(int key) {
			this.key = key;
		}

		private void insert(int newKey) {
			if (newKey < key) {
				if (this.left == null)
					left = new Node(newKey);
				else
					left.insert(newKey);
			} else {
				if (this.right == null)
					right = new Node(newKey);
				else
					right.insert(newKey);
			}
		}
	}

	private static void postorder(Node p) {
		if (p != null) {
			postorder(p.left);
			postorder(p.right);
			sb.append(p.key).append("\n");
		}
	}
}
