import java.io.*;
import java.util.StringTokenizer;

class Q1008 {
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());

        double res = A/B;

        System.out.print(res);
    }
}