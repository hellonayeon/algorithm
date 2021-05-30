import java.io.*;

class Q16017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int d1 = Integer.parseInt(br.readLine());
        int d2 = Integer.parseInt(br.readLine());
        int d3 = Integer.parseInt(br.readLine());
        int d4 = Integer.parseInt(br.readLine());
        br.close();
        
        if( (d1 == 8 || d1 == 9) && (d4 == 8 || d4 == 9) && (d2 == d3) )
            bw.write("ignore");
        else
            bw.write("answer");
        
        bw.flush();
        bw.close();
    }
}