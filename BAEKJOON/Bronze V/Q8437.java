import java.io.*;
import java.math.BigInteger;

class Q8437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        BigInteger total = new BigInteger(br.readLine());
        BigInteger diff = new BigInteger(br.readLine()); // Klaudia가 더 가지고 있는 사과 수
        BigInteger half = new BigInteger("2");
        
        BigInteger klaudia = total.add(diff).divide(half);
        BigInteger natalia = total.subtract(klaudia);
        
        System.out.println(klaudia);
        System.out.println(natalia);
    }
}