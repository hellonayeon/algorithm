import java.io.*;

class Q14264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        int L = Integer.parseInt(br.readLine());
        br.close();

        double S = Math.pow(L,2) * Math.sqrt(3) / 4;
		bw.write(String.valueOf(S));
       
        bw.flush();
        bw.close();
    }
}