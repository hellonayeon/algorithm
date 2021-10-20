import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int cnt = 0;
        for(int i = 1; i < word.length(); i++) {
            char ch = word.charAt(i);
            char prev = word.charAt(i-1);

            if(ch == '=') {
                if(prev == 'c' || prev == 's') cnt++;
                else if(prev == 'z') {
                    if(i > 1 && word.charAt(i-2) == 'd') cnt+=2;
                    else cnt++;
                }
            }
            else if(ch == '-') {
                if(prev == 'c' || prev == 'd') cnt++;
            }
            else if(ch == 'j') {
                if(prev == 'l' || prev == 'n') cnt++;
            }
        }

        System.out.println(word.length() - cnt);
    }
}