import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;


class Q1759 {
    
    static int L;
    static int C;
    static String[] alphabet;
    static StringBuilder ansBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] LC = br.readLine().split(" ");
        L = Integer.parseInt(LC[0]);
        C = Integer.parseInt(LC[1]);

        alphabet = br.readLine().split(" ");
        Arrays.sort(alphabet);

        ansBuilder = new StringBuilder();
        for(int i=0; i<=C-L; i++) {
            String str = alphabet[i];
            boolean[] visit = new boolean[C];
            visit[i] = true;
            
            dfs(i, new boolean[C], str);
        }

        System.out.print(ansBuilder);
    }

    public static void dfs(int start, boolean[] visit, String str) {
        if(str.length() == L) {
            // 적어도 모음 한 개, 자음 두 개
            int vowels = 0;
            for(int i=0; i<L; i++) {
                if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u')
                    vowels++;
            }

            if(vowels >= 1 && L-vowels >=2) {
                ansBuilder.append(str).append("\n");
            }

            return;
        }

        for(int i=start+1; i<C; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(i, visit, str + alphabet[i]);
                visit[i] = false;
            }
        }
    }
}