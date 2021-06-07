import java.io.*;
import java.util.StringTokenizer;

class Q21631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long res = a >= b ? b : a + 1;
        bw.write(String.valueOf(res));

        bw.flush();
        bw.close();
    }
}