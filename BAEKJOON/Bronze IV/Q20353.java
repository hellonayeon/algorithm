import java.io.*;

class Q20353 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        double a = Double.parseDouble(br.readLine());
        br.close();

        double res = 4 * Math.pow(a, 0.5);

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}
