import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();
        int[] cnt = new int[10];
        for(int i = 0; i < nums.length(); i++)
            cnt[nums.charAt(i) - '0']++;
        
        // 6과 9의 개수 합치기
        cnt[6] = ((cnt[6] + cnt[9]) % 2 == 0) ? (cnt[6]+cnt[9])/2 : (cnt[6]+cnt[9])/2 + 1;
        cnt[9] = 0;

        int max = cnt[0];
        for(int i = 1; i < cnt.length; i++)
            if(cnt[i] > max) max = cnt[i];

        System.out.print(max);
    }
}