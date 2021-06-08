import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.io.FileInputStream;

class FindString {

    public static String str;
    public static String find;

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/FindString_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = -1;
        while(tc != 10) {
            tc = Integer.parseInt(br.readLine());

            find = br.readLine();
            str = br.readLine();

            System.out.println("#" + tc + " " + find());
        }

        br.close();
    }

    public static int find() {
        int count = 0;
        int len = find.length();
        int idx = 0;
        while (true) {
            idx = str.indexOf(find, idx);

            if (idx == -1) break;

            idx += len;
            count++;
        }

        return count;
    }
}