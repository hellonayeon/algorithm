import java.io.*;
import java.util.StringTokenizer;

class Q19698 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        int res = (W / L) * (H / L);
        if(res > N)
            bw.write(String.valueOf(N));
        else
            bw.write(String.valueOf(res));
        
        bw.flush();
        bw.close();
    }
}