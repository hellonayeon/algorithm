import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.io.FileInputStream;

// Q2050. 알파벳을 숫자로 변환
class AlphabetToNumber {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/AlphabetToNumber_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        String str = br.readLine();
        br.close();
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++)
            sb.append(str.charAt(i) - 64).append(" ");
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
