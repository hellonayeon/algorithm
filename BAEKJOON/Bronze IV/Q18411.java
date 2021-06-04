import java.io.*;
import java.util.StringTokenizer;

class Q18411 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int res = a + b + c - Math.min(Math.min(a, b), c);
        
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}