import java.util.Scanner;
import java.math.BigInteger;

public class B8437 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger totalApple = sc.nextBigInteger();
		BigInteger difApple = sc.nextBigInteger();
		BigInteger two = new BigInteger("2");
		
		BigInteger k = (totalApple.subtract(difApple)).divide(two).add(difApple); //(total-diff)/2+diff
	    BigInteger n = (totalApple.subtract(difApple)).divide(two); //(total-diff)/2
	        
	    System.out.println(k);
	    System.out.println(n);
		
		sc.close();
	}
}
