import java.io.*;
import java.util.StringTokenizer;

class Q16727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int p1 = Integer.parseInt(st1.nextToken());
        int s1 = Integer.parseInt(st1.nextToken());
        int s2 = Integer.parseInt(st2.nextToken());
        int p2 = Integer.parseInt(st2.nextToken());
        
        int pRes = p1 + p2;
        int sRes = s1 + s2;
        
        if(pRes != sRes) {
            if(pRes > sRes)
                bw.write("Persepolis");
            else
                bw.write("Esteghlal");
        }
        else {
            if(p2 > s1)
               bw.write("Persepolis");
            else if(s1 > p2)
                bw.write("Esteghlal");
            else
                bw.write("Penalty");          
        }
        
        bw.flush();
        bw.close();
    }
}
