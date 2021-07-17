import java.io.*;

class Q2739 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 9; i++)
            sb.append(N).append(" * ").append(i).append(" = ").append(N*i).append("\n");
        
        System.out.print(sb);
    }
}