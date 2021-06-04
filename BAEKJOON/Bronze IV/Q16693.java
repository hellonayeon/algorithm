import java.io.*;
import java.util.StringTokenizer;

class Q16693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        double a1 = Double.parseDouble(st1.nextToken());
        double p1 = Double.parseDouble(st1.nextToken());
        
        double r1 = Double.parseDouble(st2.nextToken());
        double p2 = Double.parseDouble(st2.nextToken());
        
        double slice = a1 / p1;
        double whole = Math.PI * r1 * r1 / p2;
        
        if(slice > whole) 
            bw.write("Slice of pizza");
        else
            bw.write("Whole pizza");
            
        
        bw.flush();
        bw.close();
    }
}
