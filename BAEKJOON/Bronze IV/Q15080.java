import java.io.*;

class Q15080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] T1 = br.readLine().split(" : ");
        String[] T2 = br.readLine().split(" : ");
        br.close();

        int h1 = Integer.parseInt(T1[0]);
        int m1 = Integer.parseInt(T1[1]);
        int s1 = Integer.parseInt(T1[2]);
        int h2 = Integer.parseInt(T2[0]);
        int m2 = Integer.parseInt(T2[1]);
        int s2 = Integer.parseInt(T2[2]);

        int second = 0;      
        if(s2 - s1 < 0) {
            second += ((s2 + 60) - s1);
            m2 -= 1;
        }
        else {
            second += (s2 - s1);
        }

        if(m2 - m1 < 0) {
            second += ((m2 + 60) - m1) * 60;
            h2 -= 1;
        }
        else {
            second += (m2 - m1) * 60;
        }

        if(h2 - h1 < 0) {
            second += ((h2 + 24) - h1) * 3600;
        }
        else {
            second += (h2 - h1) * 3600;
        }

        bw.write(String.valueOf(second));
        bw.flush();
        bw.close();
    }
}