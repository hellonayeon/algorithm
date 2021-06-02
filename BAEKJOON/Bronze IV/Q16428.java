import java.io.*;
import java.util.StringTokenizer;
import java.math.BigInteger;

class Q16428 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        BigInteger A = new BigInteger(st.nextToken());
        BigInteger B = new BigInteger(st.nextToken());

        BigInteger quot = A.divide(B);
        BigInteger remain = A.remainder(B);

        if(A.signum() < 0) {
            if(B.signum() > 0) {
                quot = quot.subtract(new BigInteger("1"));
                remain = remain.add(B);
            }
            else {
                quot = quot.add(new BigInteger("1"));
                remain = remain.subtract(B);
            }
        }

        bw.write(quot + "\n" + remain);
        bw.flush();
        bw.close();
    }
}