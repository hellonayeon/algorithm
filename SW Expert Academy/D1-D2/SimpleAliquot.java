import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.io.FileInputStream;

// Q1933. 간단한 N 의 약수
class SimpleAliquot {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/SimpleAliquot_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
		
        StringBuilder sb = new StringBuilder();
        for(int num = 1; num <= N; num++) {
        	if(N % num == 0)
                sb.append(num).append(" ");
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        br.close();
        bw.close();
    }
}