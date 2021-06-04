import java.io.*;
import java.util.StringTokenizer;

class Q17874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        
        int w = (n/2 < h) ? h : n - h;
        int l = (n/2 < v) ? v : n - v;
        int res = w * l * 4;
        
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}