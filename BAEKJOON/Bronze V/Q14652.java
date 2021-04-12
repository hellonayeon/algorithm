import java.io.*;
import java.util.StringTokenizer;

class Q14652 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int n = K/M; // row
        int m = K%M; // col
        
        System.out.print(n + " " + m);
    }
}
