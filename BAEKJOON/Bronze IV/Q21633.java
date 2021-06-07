import java.io.*;

class Q21633 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int k = Integer.parseInt(br.readLine());
        br.close();

        double commission = 25 + (k * 0.01);
        commission = (commission < 100) ? 100 : (commission > 2000) ? 2000 : commission;

        bw.write(String.format("%.2f", commission));
        bw.flush();
        bw.close();
    }
}