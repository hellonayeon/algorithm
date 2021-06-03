import java.io.*;

class Q14935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //String x = br.readLine();
        br.readLine();
        br.close();

        bw.write("FA");
        
        /*
        while(x.length()!= 1)
            x = fa(x);
        
        if(x.length() == 1)
            bw.write("FA");
        else
            bw.write("NFA");
        */
        
        bw.flush();
        bw.close();
        
    }
    
    public static String fa(String x) {
        String res = (x.charAt(0) - '0') * x.length() + "";
        return res;
    }
}