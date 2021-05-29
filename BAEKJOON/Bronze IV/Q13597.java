import java.io.*;
import java.util.StringTokenizer;

class Q13597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        br.close();
        
        if(A == B)
            bw.write(Integer.toString(A));
        else
            bw.write(Integer.toString( Math.max(A, B) ));
        
        bw.flush();
        bw.close();
    }
}