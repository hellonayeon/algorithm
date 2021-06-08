import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

import java.io.FileInputStream;

class Flatten {

    static int[] box = new int[100];
    static int dumpCount;
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Flatten_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            dumpCount = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");

            for(int idx = 0; idx < box.length; idx++)
                box[idx] = Integer.parseInt(str[idx]);

            Arrays.sort(box);
            dump();

            int diff = box[99] - box[0];

            System.out.println("#" + tc + " " + diff);
        }

        br.close();
    }

    public static void dump() {
        if(dumpCount == 0) return;
        
        while(dumpCount > 0) {
            box[0] += 1;
            box[99] -= 1;
            dumpCount--;
        
            Arrays.sort(box);
        }
    }
}