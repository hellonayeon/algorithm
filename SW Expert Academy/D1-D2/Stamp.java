import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.io.FileInputStream;

// Q2046. 스탬프 찍기
class Stamp {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Stamp_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        for (int i = 0; i < n; i++)
            bw.write("#");

        bw.flush();
        bw.close();
    }
}
