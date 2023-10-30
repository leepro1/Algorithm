/*
 * https://www.acmicpc.net/problem/14425
 * 문자열 집합
 * 문자열 검사 알고리즘 중 트라이를 이용하자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Trie root = new Trie();

		while (n-- > 0) {
			String str = br.readLine();
			root.insert(str);
		}
		
		int cnt=0;
		while(m-->0) {
			String str = br.readLine();
			if(root.contains(str))
				cnt++;
		}
		System.out.println(cnt);
	}

	static class TrieNode {
		Map<Character, TrieNode> childNodeMap = new HashMap<>();
		boolean lastCharacter;
	}

	static class Trie {
		TrieNode rootNode = new TrieNode();

		void insert(String word) {
			TrieNode thisNode = this.rootNode;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);

				thisNode.childNodeMap.putIfAbsent(c, new TrieNode());
				thisNode = thisNode.childNodeMap.get(c);
			}
			thisNode.lastCharacter = true;
		}

		boolean contains(String word) {
			TrieNode thisNode = this.rootNode;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				TrieNode node = thisNode.childNodeMap.get(c);

				if (node == null)
					return false;

				thisNode = node;
			}

			return thisNode.lastCharacter;
		}
	}
}
