import java.io.*;
import java.util.StringTokenizer;

class Q5575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] t = new int[3][6]; // 출근시간 퇴근시간
        
        StringTokenizer st;
        for(int i=0; i<t.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            for(int j=0; j<t[i].length; j++){
                t[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[][] h = new int[3][3]; // 근무시간
        for(int i=0; i<t.length; i++) {
            if(t[i][5] - t[i][2] < 0) { // 퇴근시간(초) - 출근시간(초)
                h[i][2] = (t[i][5] + 60) - t[i][2]; 
                t[i][4] -= 1;
            }
            else {
                h[i][2] = t[i][5] - t[i][2];
            }
            
            if(t[i][4] - t[i][1] < 0) { // 퇴근시간(분) - 출근시간(분)
                h[i][1] = (t[i][4] + 60) - t[i][1];
                t[i][3] -= 1;
            }
            else {
                h[i][1] = t[i][4] - t[i][1];
            }
            
            h[i][0] = t[i][3] - t[i][0];    
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<h.length; i++) {
            sb.append(h[i][0]).append(" ").append(h[i][1]).append(" ").append(h[i][2]).append(" ")
                .append('\n');
        }
        
        System.out.println(sb);
        
    }
}