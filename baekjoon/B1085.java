package baekjoon;

import java.util.Scanner;

public class B1085 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		int w=sc.nextInt();
		int h=sc.nextInt();
		
		int[] distance=new int[4];
		
		distance[0] = h-y;
		distance[1] = x;
		distance[2] = y;
		distance[3] = w-x;

		int min=distance[0];
		
		for (int i=0;i<4;i++)
		{
			if (min > distance[i])
				min = distance[i];
		}
		System.out.println(min);
		sc.close();
	}
}
