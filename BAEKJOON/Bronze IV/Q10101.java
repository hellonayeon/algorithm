import java.io.*;

class Q10101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        br.close();
        
        if( (a+b+c) == 180 ) {
            if(a == 60 && b == 60 && c == 60)
                bw.write("Equilateral");
            else if (a == b || a == c || b == c)
                bw.write("Isosceles");
            else
                bw.write("Scalene");
        }
        else {
            bw.write("Error");
        }
        
        bw.flush();
        bw.close();
    }
}