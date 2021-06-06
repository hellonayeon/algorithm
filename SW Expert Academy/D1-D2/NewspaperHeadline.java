import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.io.FileInputStream;

// Q2047. 신문 헤드라인
class NewspaperHeadline {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/NewspaperHeadline_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        br.close();
        
        bw.write(str.toUpperCase());
        bw.flush();
        bw.close();
    }
}
