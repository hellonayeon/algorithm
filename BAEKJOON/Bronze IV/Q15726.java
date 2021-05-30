import java.io.*;
import java.util.StringTokenizer;

class Q15726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        double A = Double.parseDouble(st.nextToken());
        double B = Double.parseDouble(st.nextToken());
        double C = Double.parseDouble(st.nextToken());
        
        double n1 = A * B / C ;
        double n2 = A / B * C ;
        
        if(n1 > n2)
            bw.write(String.valueOf((int)n1));
        else
            bw.write(String.valueOf((int)n2));

        bw.flush();
        bw.close();
    }
}