import java.io.*;

class Q15727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        
        int t = (L % 5 == 0) ? L/5 : (L/5 + 1) ; 
        
        System.out.print(t);
    }
}