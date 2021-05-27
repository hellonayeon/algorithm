import java.io.*;

class Q6768 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int J = Integer.parseInt(br.readLine());
        br.close();
        
        int res = (J-1) * (J-2) * (J-3) / 6;
        bw.write(Integer.toString(res));

        bw.flush();
        bw.close();
    }
}