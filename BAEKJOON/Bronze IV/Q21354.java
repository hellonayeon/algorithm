import java.io.*;
import java.util.StringTokenizer;

class Q21354 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        int axel = Integer.parseInt(st.nextToken()) * 7;
        int petra = Integer.parseInt(st.nextToken()) * 13;

        if(axel > petra)
            bw.write("Axel");
        else if(axel < petra)
            bw.write("Petra");
        else
            bw.write("lika");

        bw.flush();
        bw.close();
    }
}
