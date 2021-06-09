import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.io.FileInputStream;
import java.util.Base64;
import java.util.Base64.Decoder;

class BinaryToString {

    static Decoder decoder = Base64.getDecoder();
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/BinaryToString_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            String res = new String( decoder.decode(br.readLine()) );
            System.out.println("#" + tc + " " + res);
        }
    }
}