import java.io.*;

class Q18005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        long n = Long.parseLong(br.readLine());
        
        if(n % 2 != 0) // n이 홀수일 경우: 합이 짝수 또는 홀수 모두 가능
            bw.write("0");
        
        else if (n / 2 % 2 != 0) 
            bw.write("1");
        
        else
            bw.write("2");
        
        
        bw.flush();
        bw.close();
    }
}
