import java.io.*;
import java.util.StringTokenizer;

class Q11466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();

        float h = Float.parseFloat(st.nextToken());
        float w = Float.parseFloat(st.nextToken());

        float tmp;
        if (h < w) {
            tmp = h;
            h = w;
            w = tmp;
        }

        if (h > w * 3)
            bw.write(Float.toString(w));
        else if (h > w * 1.5)
            bw.write(Float.toString(h/3));
        else
            bw.write(Float.toString(w/2));

        bw.flush();
        bw.close();
    }
}
