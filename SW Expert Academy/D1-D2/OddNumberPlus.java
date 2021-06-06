import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.io.FileInputStream;

// Q2072. 홀수만 더하기
class OddNumberPlus {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/OddNumberPlus_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String[] nums = br.readLine().split(" ");

            int sum = 0;
            for(int i=0; i<nums.length; i++) {
                int num = Integer.parseInt(nums[i]);
                if(num % 2 == 1) sum += num;
            }

            bw.write("#" + test_case + " " + sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
