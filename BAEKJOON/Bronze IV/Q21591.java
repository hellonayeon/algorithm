import java.io.*;
import java.util.StringTokenizer;

class Q21591 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        int nw = Integer.parseInt(st.nextToken());
        int nh = Integer.parseInt(st.nextToken());
        int sw = Integer.parseInt(st.nextToken());
        int sh = Integer.parseInt(st.nextToken());

        if(sw <= nw - 2 && sh <= nh - 2)
            bw.write("1");
        else
            bw.write("0");

        bw.flush();
        bw.close();
    }
}
