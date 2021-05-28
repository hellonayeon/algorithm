import java.io.*;
import java.util.StringTokenizer;

class Q11466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        float h = Float.parseFloat(st.nextToken());
        float w = Float.parseFloat(st.nextToken());

        float res = (h > w) ? h/3 : h/2;
        bw.write(Float.toString(res));
        bw.flush();
        bw.close();
    }
}
