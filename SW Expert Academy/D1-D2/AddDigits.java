import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.io.FileInputStream;

// Q2058. 자릿수 더하기
class AddDigits {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/AddDigits_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();

        int sum = 0;
        for(int i = 0; i < N.length(); i++)
            sum += N.charAt(i) - '0';

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}