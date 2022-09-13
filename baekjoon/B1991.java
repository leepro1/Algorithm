//https://www.acmicpc.net/problem/1991
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991 {
	public static Node root;
	
	public static class Node{ 
		char key;
		Node leftChild;
		Node rightChild;
	
		Node(char key){
			this.key=key;
		}
	}
	
	private static void insert(char newKey,char left,char right ) {
		if(root==null) {
			if(newKey!='.') 
				root=new Node(newKey);
			if(left!='.') 
				root.leftChild=new Node(left);
			if(right!='.') 
				root.rightChild=new Node(right);
		}
		else {
			search(root,newKey,left,right);
		}
	}
	
	private static void search(Node root,char key,char left,char right) {
		if(root==null) return;
		if(root.key==key) {
			if(left!='.') 
				root.leftChild=new Node(left);
			if(right!='.') 
				root.rightChild=new Node(right);
		}
		else {
			search(root.leftChild,key,left,right);
			search(root.rightChild,key,left,right);
		}
	}

	public static void preOrder() {
		preOrder(root);
	}
	
	private static void preOrder(Node p) {
		if(p!=null) {
			System.out.print(p.key);
			preOrder(p.leftChild);
			preOrder(p.rightChild);
		}
	}
	
	public static void inOrder() {
		inOrder(root);
	}
	
	private static void inOrder(Node p) {
		if(p!=null) {
			inOrder(p.leftChild);
			System.out.print(p.key);
			inOrder(p.rightChild);
		}
	}
	
	public static void postOrder() {
		postOrder(root);
	}
	
	private static void postOrder(Node p) {
		if(p!=null) {
			postOrder(p.leftChild);
			postOrder(p.rightChild);
			System.out.print(p.key);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		
		while(N-->0) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			insert(st.nextToken().charAt(0), st.nextToken().charAt(0),st.nextToken().charAt(0));
		}
		
		preOrder();
		System.out.println();
		inOrder();
		System.out.println();
		postOrder();
	}
}
