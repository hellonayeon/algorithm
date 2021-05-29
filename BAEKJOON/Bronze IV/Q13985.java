import java.io.*;

class Q13985 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String str = br.readLine();
        br.close();
        
        int a = str.charAt(0) - '0';
        int b = str.charAt(4) - '0';
        int c = str.charAt(8) - '0';
        
        if(a+b == c)
            bw.write("YES");
        else
            bw.write("NO");
        
        bw.flush();
        bw.close();
    }
}