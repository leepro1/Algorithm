import java.util.Scanner;

public class B3003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] normPiece = {1,1,2,2,2,8};
		int[] havePiece = new int[6];
		int[] diffPiece = new int[6];
		
		for(int i=0;i<havePiece.length;i++) {
			havePiece[i] = sc.nextInt();
			diffPiece[i] = normPiece[i] - havePiece[i];
		}
		for(int i=0;i<diffPiece.length;i++) {
			System.out.print(diffPiece[i]+" ");
		}
		
		sc.close();
	}
}
