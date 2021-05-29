// 출처: https://jaimemin.tistory.com/1596 [꾸준함]

import java.io.*;
import java.util.StringTokenizer;

class Q13610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        
        int res; 
        for (res = 1; (Y - X) * res < Y; res++);
        
        bw.write(Integer.toString(res));
        bw.flush();
        bw.close();
    }
}