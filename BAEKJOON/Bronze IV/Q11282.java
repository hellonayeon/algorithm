import java.io.*;

class Q11282 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        br.close();
        
        bw.write( (char) n+44031 );
        bw.flush();
        bw.close();
    }
}