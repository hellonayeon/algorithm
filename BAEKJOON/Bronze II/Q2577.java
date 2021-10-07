import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[10];
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        char[] chs = String.valueOf(A*B*C).toCharArray();
        for(int i = 0; i < chs.length; i++) {
            nums[chs[i]-'0']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++) {
            sb.append(nums[i]).append("\n");
        }

        System.out.print(sb);
    }
}