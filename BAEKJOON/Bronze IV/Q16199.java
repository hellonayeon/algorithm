import java.io.*;
import java.util.StringTokenizer;

class Q16199 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int y1 = Integer.parseInt(st1.nextToken());
        int m1 = Integer.parseInt(st1.nextToken());
        int d1 = Integer.parseInt(st1.nextToken());
        int y2 = Integer.parseInt(st2.nextToken());
        int m2 = Integer.parseInt(st2.nextToken());
        int d2 = Integer.parseInt(st2.nextToken());
        
        int a1, a2, a3; // 만 나이, 세는 나이, 연 나이
        if(m1 > m2) {
            a1 = y2 - y1 - 1;
        }
        else if(m1 < m2) {
            a1 = y2 - y1;
        }
        else {
            if(d1 > d2)
                a1 = y2 - y1 - 1;
            else
                a1 = y2 - y1;
        }
        
        a2 = y2 - y1 + 1;
        a3 = y2 - y1;
        
        StringBuilder sb = new StringBuilder();
        sb.append(a1).append("\n").append(a2).append("\n").append(a3);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}