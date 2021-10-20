import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        // 알파벳 개수 카운트
        int[] cnt = new int[26];
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c < 91) cnt[c - 65]++;
            else cnt[c - 97]++;
        }

        // 가장 많이 나온 알파벳 구하기
        int max = cnt[0];
        int ch = 0;
        for(int i = 1; i < 26; i++) {
            if(cnt[i] > max) {
                max = cnt[i];
                ch = i;
            }
            // '?' ascii == 63
            else if(cnt[i] == max) ch = -2;
        }

        System.out.println((char)(65+ch));
    }
}
