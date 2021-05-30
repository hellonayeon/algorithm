import java.io.*;
import java.math.BigInteger;

class Q15048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        BigInteger A = new BigInteger(br.readLine());
        br.close();
        
        BigInteger res = A.remainder(new BigInteger("3"));
        bw.write(String.valueOf(res));
        
        bw.flush();
        bw.close();
    }
}