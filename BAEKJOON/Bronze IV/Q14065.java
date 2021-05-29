import java.io.*;

class Q14065 {
    static double L_PER_GALLON = 3.785411784;
    static double KM_PER_MILE = 1.609344;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        double mile = Double.parseDouble(br.readLine());
        br.close();

        double km = KM_PER_MILE * mile;
        double res = L_PER_GALLON * 100 / km;

        bw.write(String.format("%.6f", res));
        bw.flush();
        bw.close();
    }
}