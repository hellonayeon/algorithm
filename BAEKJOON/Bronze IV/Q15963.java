import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        if(N == M)
            bw.write("1");
        else
            bw.write("0");
        
        bw.flush();
        bw.close();
    }
}