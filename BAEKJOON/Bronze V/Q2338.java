import java.io.*;
import java.math.BigInteger;

// Scanner와 BufferReader의 차이

public class Q2338 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger A = new BigInteger(br.readLine()); // 개행문자까지 받아온 후 형변환
		BigInteger B = new BigInteger(br.readLine());
        
        System.out.println(A.add(B));
		System.out.println(A.subtract(B));
		System.out.println(A.multiply(B));
	}
}
