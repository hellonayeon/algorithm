import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.io.FileInputStream;

// Q2025. N줄 덧셈
class SumN {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/SumN_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        int sum = 0;
        for(int i = 1; i <= N; i++)
        	sum += i;
		
        bw.write(String.valueOf(sum));
        bw.flush();
        
        br.close();
        bw.close();
    }
}