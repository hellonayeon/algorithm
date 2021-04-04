import java.io.*;
import java.util.StringTokenizer;
import java.math.BigInteger;

class Q13277 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());
        
        System.out.print(A.multiply(B));
    }
}