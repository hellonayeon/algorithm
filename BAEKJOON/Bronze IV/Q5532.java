import java.io.*;

class Q5532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        
        int lang = (A%C == 0) ? A/C : A/C + 1;
        int math = (B%D == 0) ? B/D : B/D + 1;
        
        System.out.println(L - Math.max(lang,math));
    }
}