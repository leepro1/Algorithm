import java.util.Scanner;

public class B11283 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();
		
		char charWord = word.charAt(0); //0Àº index¹øÈ£
		System.out.println((int)charWord-44031); 
		
		sc.close();
	}
}
