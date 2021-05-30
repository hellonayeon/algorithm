import java.io.*;
import java.util.StringTokenizer;

class Q15700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        long res = N * M / 2;
        bw.write(String.valueOf(res));
        
        bw.flush();
        bw.close();
    }
}