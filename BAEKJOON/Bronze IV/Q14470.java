import java.io.*;

class Q14470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        br.close();
        
        int second;
        if(A < 0)
            second = Math.abs(A) * C + D + B * E ;
        else if (A > 0)
            second = (B - A) * E ;
        else
            second = D + E * B;
        
        bw.write(second);
        bw.flush();
        bw.close();
    }
}