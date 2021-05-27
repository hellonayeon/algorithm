import java.io.*;

class Q10039 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int score, sum=0;
        for(int i=0; i<5; i++) {
            score = Integer.parseInt(br.readLine());
            if(score < 40) score = 40;
            sum += score;
        }
        br.close();
        
        int avg = sum/5;
        bw.write(Integer.toString(avg));
        bw.flush();
        bw.close();           
    }
}