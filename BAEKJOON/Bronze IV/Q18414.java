import java.io.*;
import java.util.StringTokenizer;

class Q18414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int X = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        int res;
        if(X < L)
            res = L;
        else if(X > R)
            res = R;
        else
            res = X;
        
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}