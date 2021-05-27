import java.io.*;
import java.util.StringTokenizer;

class Q8710 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int k = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int diff = (w-k);
        int res = ( diff <= 0 ) ? 0 : ( diff % m == 0 ) ? diff / m : diff / m + 1;
        
        bw.write(Integer.toString(res));
        bw.flush();
        bw.close();
    }
}