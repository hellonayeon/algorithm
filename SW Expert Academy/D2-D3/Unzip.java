import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.io.FileInputStream;

class Unzip {
    final static int DOC_LENGTH = 10;
    static int pos;
    static StringBuilder sb;

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Unzip_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            sb = new StringBuilder();
            pos = 0;
            for(int i = 0; i < N; i ++) {
                unzip(br.readLine().split(" "));
            }

            System.out.println("#" + tc + "\n" + sb);
        }
    }

    public static void unzip(String[] str) {
        String alphabet = str[0];
        int count = Integer.parseInt(str[1]);

        while(count > 0) {
            sb.append(alphabet);
            pos++; count--;

            if(pos == DOC_LENGTH) {
                sb.append("\n");
                pos = 0;
            }
        }
    }
}