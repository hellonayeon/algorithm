import java.io.*;

class Q15236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        br.close();
        
        int res = (N * (N + 1) * (N + 2)) / 2;
        bw.write(String.valueOf(res));
        
        bw.flush();
        bw.close();
    }
}