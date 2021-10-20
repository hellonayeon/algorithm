import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();

        // 알파벳 개수 카운트
        int[] cnt = new int[26];
        for(int i = 0; i < word.length(); i++) {
            cnt[(word.charAt(i) - 0) - 65]++;
        }

        // 가장 많이 나온 알파벳 구하기
        int max = cnt[0], tmp = 0;
        int idx = 0;
        for(int i = 1; i < 26; i++) {
            if(cnt[i] > max) {
                max = cnt[i];
                idx = i;
            }
            else if(cnt[i] == max) tmp = cnt[i];
        }

        if(max == tmp) {
            System.out.println("?");
        }
        else {
            System.out.println((char)('A' + idx));
        }
    }
}
