import java.io.*;

class Q14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        br.close();
        
        if(x * y > 0) {
            if(x > 0)
                bw.write("1");
            else
                bw.write("3");
        }
        else {
            if(x < 0)
                bw.write("2");
            else
                bw.write("4");
        }
        
        bw.flush();
        bw.close();
    }
}