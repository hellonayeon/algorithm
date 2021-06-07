import java.io.*;

class Q21335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        double a = Double.parseDouble(br.readLine());
        br.close();

        double r = Math.sqrt(a/Math.PI);
        double res = 2 * Math.PI * r ;

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}