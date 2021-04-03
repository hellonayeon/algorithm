import java.io.*;

class Q5554 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int total=0; // 총 걸린 시간(초)
        for(int i=0; i<4; i++)
            total += Integer.parseInt(br.readLine());
        
        System.out.println(total/60);
        System.out.println(total%60);
    }
}