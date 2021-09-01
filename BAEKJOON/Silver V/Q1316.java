import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 총 단어의 개수

        int cnt = N;
        while(N-- > 0) {
            String word = br.readLine();
            boolean[] chk = new boolean[26];

            char prev = word.charAt(0);
            chk[(int)prev - 97] = true;

            for(int i = 1; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(prev == ch) continue;
                if(chk[(int)ch - 97]) {
                    cnt--;
                    break;
                }

                // 새로운 문자가 나온 경우
                prev = ch;
                chk[(int)ch - 97] = true;
            }
        }

        System.out.println(cnt);
    }
}