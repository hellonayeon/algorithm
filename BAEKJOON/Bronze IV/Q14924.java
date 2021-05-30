import java.io.*;
import java.util.StringTokenizer;

class Q14924 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        int F = D / (S*2) * T;
        bw.write(String.valueOf(F));
        
        bw.flush();
        bw.close();
    }
}