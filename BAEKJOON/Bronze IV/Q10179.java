import java.io.*;

class Q10179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        
        double[] price = new double[n];
        for(int i=0; i<n; i++)
            price[i] = Double.parseDouble(br.readLine()) * 0.8;
        
        br.close();
        
        for(int i=0; i<n; i++)
            bw.write(String.format("$%.2f\n", price[i]));    
        
        bw.flush();
        bw.close();
    }
}