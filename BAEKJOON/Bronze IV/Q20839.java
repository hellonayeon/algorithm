import java.io.*;
import java.util.StringTokenizer;

class Q20839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        br.close();

        int x1 = Integer.parseInt(st1.nextToken()); // double
        int y1 = Integer.parseInt(st1.nextToken());

        int x2 = Integer.parseInt(st2.nextToken());
        int y2 = Integer.parseInt(st2.nextToken());

        // if(x2 == x1 && y2 == y1 && z2 == z1) {
        //     bw.write("A");
        // }
        // else if (x2 >= Math.round(x1/2) && y2 == y1 && z2 == z1) {
        //     bw.write("B");
        // }
        // else if (y2 == y1 && z2 == z1) {
        //     bw.write("C");
        // }  
        // else if (y2 >= Math.round(y1/2) && z2 == z1) {
        //     bw.write("D");
        // }
        // else {
        //     bw.write("E");
        // }

        if(y2 * 2 < y1) 
            bw.write("E");
        else if(y2 < y1) 
            bw.write("D");
        else if(x2 * 2 < x1) 
            bw.write("C");
        else if(x2 < x1) 
            bw.write("B");
        else 
            bw.write("A");

        bw.flush();
        bw.close();
    }
}