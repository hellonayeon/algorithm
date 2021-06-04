import java.io.*;
import java.util.StringTokenizer;

class Q20215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        double w = Double.parseDouble(st.nextToken());
        double h = Double.parseDouble(st.nextToken());
        
        double res = (w + h) - Math.sqrt(w * w + h * h);
        bw.write(String.valueOf(res));
        
        bw.flush();
        bw.close();
    }
}