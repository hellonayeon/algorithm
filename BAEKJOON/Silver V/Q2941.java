import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q2941 {

    final static String[] CROATIA = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();

        int cCnt = 0;
        for(String croatia : CROATIA) {
            int cLen = croatia.length();

            for(int i = 0; i < word.length-(cLen-1); i++) {
                String tmp = "";
                for(int j = i; j < i+cLen; j++) {
                    tmp += word[j];
                }
                
                if(tmp.equals(croatia)) {
                    for(int j = i; j < i+cLen; j++) word[j] = ' ';
                    cCnt++;
                    i += cLen-1;
                } 
            }
        }

        int tCnt = cCnt;
        for(char ch : word) {
            if(ch != ' ') tCnt++;
        }

        System.out.println(tCnt);
    }
}
