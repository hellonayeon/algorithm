import java.io.*;
import java.util.StringTokenizer;

class Q17903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int m = Integer.parseInt(st.nextToken());
        bw.write( (m < 8) ? "unsatisfactory" : "satisfactory" );
        
        bw.flush();
        bw.close();
    }
}