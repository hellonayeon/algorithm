import java.io.*;

class Q15873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        br.close();
        
        int A, B;
        if(input.length() == 2) {
            A = input.charAt(0) - '0';
            B = input.charAt(1) - '0';
        }
        else if(input.length() == 3) {
            if(input.charAt(1) == '0') {
                A = 10;
                B = (input.charAt(2) - '0');
            }
            else {
                A = (input.charAt(0) - '0');
                B = 10;
            }
        }
        else {
            A = B = 10;
        }
        
        int res = A + B;
        bw.write(String.valueOf(res));
        
        bw.flush();
        bw.close();
    }
}