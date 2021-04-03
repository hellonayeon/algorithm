import java.io.*;

class Q6749 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int Y = Integer.parseInt(br.readLine()); // youngest child age
        int M = Integer.parseInt(br.readLine()); // middle child age
        
        int O = M + (M - Y); // oldest child age
        
        System.out.println(O);
    }
}