import java.io.*;

class Q10707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        br.close();
        
        int X = A * P; // X사의 요금
        int Y = (P > C) ? B + (P-C)*D : B;
        
        bw.write(Integer.toString(Math.min(X, Y)));
        bw.flush();
        bw.close();
    }
}