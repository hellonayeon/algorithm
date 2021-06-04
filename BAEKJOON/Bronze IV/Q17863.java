import java.io.*;

class Q17863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        bw.write( (br.readLine().substring(0,3).equals("555")) ? "YES" : "NO" );
        
        br.close();
        bw.flush();
        bw.close();
    }
}