import java.io.*;

class Q20233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int a = Integer.parseInt(br.readLine());
        int x = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        br.close();
        
        int o1 = (T <= 30) ? a : a + (T - 30) * x * 21 ;
        int o2 = (T <= 45) ? b : b + (T - 45) * y * 21 ;
        
        StringBuilder sb = new StringBuilder();
        sb.append(o1).append(" ").append(o2);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}