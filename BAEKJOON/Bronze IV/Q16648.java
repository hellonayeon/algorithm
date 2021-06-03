import java.io.*;
import java.util.StringTokenizer;

class Q16648 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        double t = Double.parseDouble(st.nextToken());
        double p = Double.parseDouble(st.nextToken());
        
        double d ; // 1분당 줄어든 배터리량
        double res;
        if(p > 20) {
            d = t / (100 - p) ;
            res = (p - 20) * d + 20 * d * 2 ;
        }
        else {
            d = t / ((20 - p) * 2 + 80) ;
            res = p * d * 2 ;
        }
        
        bw.write(String.valueOf(res));
        
        bw.flush();
        bw.close();
    }
}