import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

class Q1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); // N
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int min = 1000000, max = 0;
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if(num < min) min = num;
            if(num > max) max = num;
        }

        int num = min * max;
        System.out.println(num);
    }
}