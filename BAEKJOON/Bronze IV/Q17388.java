import java.io.*;
import java.util.StringTokenizer;

class Q17388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        if(S + K + H < 100) {
            int min = Math.min(Math.min(S, K), H);
            
            if(S == min)
                bw.write("Soongsil");
            else if(K == min)
                bw.write("Korea");
            else
                bw.write("Hanyang");
        }
        else {
            bw.write("OK");
        }
        
        bw.flush();
        bw.close();
    }
}