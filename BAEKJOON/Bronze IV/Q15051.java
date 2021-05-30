import java.io.*;

class Q15051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int A1 = Integer.parseInt(br.readLine());
        int A2 = Integer.parseInt(br.readLine());
        int A3 = Integer.parseInt(br.readLine());
        
        int a1 = A2*2 + A3*4;
        int a2 = A1*2 + A3*2;
        int a3 = A1*4 + A2*2;
        
        int minute = Math.min(Math.min(a1, a2), a3);
        
        bw.write(String.valueOf(minute));
        bw.flush();
        bw.close();
    }
}