import java.math.BigInteger;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		String x, z ;

		for ( int n = 0; n < cases ; n++ ) {
			x = scanner.next();
			z = scanner.next();
			int lx = x.length() , lz = z.length() ;

			BigInteger[][] dp = new BigInteger[lx+1][lz+1];

			for ( int i = 0 ; i < lx + 1 ; i ++ ) dp[i][0] = BigInteger.valueOf(1);

			for ( int i = 1 ; i < lz + 1 ; i ++ ) dp[0][i] = BigInteger.valueOf(0);

			for ( int i = 1 ; i < lx + 1 ; i ++ )
				for ( int j = 1 ; j < lz + 1 ; j ++ ){
					dp[i][j] = dp[i-1][j] ;
					if ( x.charAt(i-1) == z.charAt(j-1) )dp[i][j] = dp[i][j].add(dp[i-1][j-1]);
				} 
				
			System.out.println(dp[lx][lz]);
		}
	}
}