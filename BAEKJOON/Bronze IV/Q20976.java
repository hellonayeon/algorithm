import java.io.*;
import java.util.StringTokenizer;

class Q20976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int res = (A+B+C) - Math.max(Math.max(A, B), C) - Math.min(Math.min(A, B), C);
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}