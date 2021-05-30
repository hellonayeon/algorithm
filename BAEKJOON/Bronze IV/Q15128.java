import java.io.*;
import java.util.StringTokenizer;

class Q15128 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        long p1 = Long.parseLong(st.nextToken());
        long q1 = Long.parseLong(st.nextToken());
        long p2 = Long.parseLong(st.nextToken());
        long q2 = Long.parseLong(st.nextToken());
        
        if(p1 * p2 % (q1 * q2 * 2) == 0)
            bw.write("1");
        else
            bw.write("0");
        
        bw.flush();
        bw.close();
    }
}