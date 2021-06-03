import java.io.*;

class Q16486 {
    
    public static double PI = 3.141592;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        double d1 = Double.parseDouble(br.readLine());
        double d2 = Double.parseDouble(br.readLine());
        
        double res = ( 2 * PI * d2 ) + ( 2 * d1 );
        
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}