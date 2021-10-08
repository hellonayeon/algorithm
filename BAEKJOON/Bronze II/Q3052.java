import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.HashSet;

class Q3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < 10; i++) {
            int remain = Integer.parseInt(br.readLine()) % 42;
            set.add(remain);
        }

        System.out.println(set.size());
    }
}