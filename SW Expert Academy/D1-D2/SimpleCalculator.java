import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.io.FileInputStream;

import java.util.StringTokenizer;

// Q1938. 아주 간단한 계산기
class SimpleCalculator {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/SimpleCalculator_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        bw.write(String.valueOf(a+b) + "\n");
        bw.write(String.valueOf(a-b) + "\n");
        bw.write(String.valueOf(a*b) + "\n");
        bw.write(String.valueOf(a/b));
        
        bw.flush();
        bw.close();
    }
}