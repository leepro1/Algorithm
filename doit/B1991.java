/*
 * https://www.acmicpc.net/problem/1991
 * 트리 순회
 * Node형식으로 값을 저장한 후 재귀방식으로 순회하자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991 {
	static Node root = new Node('A');
	static StringBuilder sb = new StringBuilder();

	static class Node {
		char value;
		Node leftChild;
		Node rightChild;

		Node(char value) {
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			insert(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
		}

		preOrder(root);
		sb.append("\n");
		inOrder(root);
		sb.append("\n");
		postOrder(root);

		System.out.println(sb);
	}

	static void insert(char value, char leftValue, char rightValue) {
		Node searchNode = search(root, value);

		if (searchNode == null) {
			searchNode = new Node(value);
		}
		if (leftValue != '.') {
			searchNode.leftChild = new Node(leftValue);
		}
		if (rightValue != '.') {
			searchNode.rightChild = new Node(rightValue);
		}
	}

	// value를 이용하여 Node 찾기
	static Node search(Node nowNode, char value) {
		if (nowNode == null || nowNode.value == value) {
			return nowNode;
		}
		
		Node returnNode1 = search(nowNode.leftChild, value);
		if (returnNode1 != null)
			return returnNode1;
		
		Node returnNode2 = search(nowNode.rightChild, value);
		if (returnNode2 != null)
			return returnNode2;
		
		return null;
	}

	static void preOrder(Node node) {
		if (node != null) {
			sb.append(node.value);
			preOrder(node.leftChild);
			preOrder(node.rightChild);
		}
	}

	static void inOrder(Node node) {
		if (node != null) {
			inOrder(node.leftChild);
			sb.append(node.value);
			inOrder(node.rightChild);
		}
	}

	static void postOrder(Node node) {
		if (node != null) {
			postOrder(node.leftChild);
			postOrder(node.rightChild);
			sb.append(node.value);
		}
	}
}
