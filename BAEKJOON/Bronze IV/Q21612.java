import java.io.*;

class Q21612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int B = Integer.parseInt(br.readLine());
        br.close();

        int P = 5 * B - 400;
        int res = (P < 100) ? 1 : (P == 100) ? 0 : -1 ;

        StringBuilder sb = new StringBuilder();
        sb.append(P).append("\n").append(res);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}