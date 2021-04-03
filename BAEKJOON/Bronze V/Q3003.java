import java.io.*;

class Q3003 {
    public static void main(String[] args) throws IOException {
        int[] chess = {1, 1, 2, 2, 2, 8}; // 체스에서 사용하는 피스
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] white = br.readLine().split(" "); // 동혁이가 찾은 흰색 피스
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<chess.length; i++)
            sb.append( chess[i] - Integer.parseInt(white[i]) ).append(" ");
        
        System.out.println(sb);
    }    
}
