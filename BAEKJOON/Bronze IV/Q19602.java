import java.io.*;

class Q19602 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int S = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int L = Integer.parseInt(br.readLine());
        br.close();
        
        int score = 1 * S + 2 * M + 3 * L ;
        bw.write( (score >= 10) ? "happy" : "sad" );
        
        bw.flush();
        bw.close();
    }
}
