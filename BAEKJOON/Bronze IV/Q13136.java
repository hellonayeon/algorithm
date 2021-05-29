import java.io.*;
import java.util.StringTokenizer;

class Q13136 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        long R = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());
        
        long res = 1;
        res *= (R % N == 0) ? R/N : R/N+1;
        res *= (C % N == 0) ? C/N : C/N+1;
        
        bw.write(Long.toString(res));
        bw.flush();
        bw.close();
    }
}