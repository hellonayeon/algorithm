import java.io.*;

// 가우스의 덧셈 법칙
class Q21185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        br.close();

        if(N % 2 != 0) {
            bw.write("Either");
        }
        else {
            if(N / 2 % 2 == 0)
                bw.write("Even");
            else
                bw.write("Odd");
        }
        
        bw.flush();
        bw.close();
    }
}