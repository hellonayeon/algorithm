import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.util.StringTokenizer;

import java.io.FileInputStream;

// Q1936. 1대1 가위바위보
class RockPaperScissors {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/RockPaperScissors_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if( (A == 1 && B == 3) || (A == 2 && B == 1) || (A == 3 && B == 2) )
            bw.write("A");
        else
            bw.write("B");

        bw.flush();
        bw.close();
    }
}