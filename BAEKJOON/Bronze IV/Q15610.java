import java.io.*;

class Q15610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long a = Long.parseLong(br.readLine());
        br.close();
        
        double res = Math.sqrt(a) * 4;
        bw.write(String.valueOf(res));
        
        bw.flush();
        bw.close();
    }
}