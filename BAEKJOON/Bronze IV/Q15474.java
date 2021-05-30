import java.io.*;
import java.util.StringTokenizer;

class Q15474 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        int price1, price2;
        price1 = (N % A == 0) ? (N/A) * B : (N/A + 1) * B ;
        price2 = (N % C == 0) ? (N/C) * D : (N/C + 1) * D ;
        
        int price = Math.min(price1, price2);
        bw.write(String.valueOf(price));
        
        bw.flush();
        bw.close();
    }
}