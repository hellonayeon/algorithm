import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] nums = new int[N.length()];
        for(int i = 0; i < nums.length; i++)
            nums[i] = N.charAt(i) - '0';

        // 선택정렬
        for (int i = 0; i < nums.length-1; i++) {
            int max = i;

            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] > nums[max]) max = j;
            }

            int tmp = nums[i];
            nums[i] = nums[max];
            nums[max] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for(int n : nums)
            sb.append(n);
        
        System.out.println(sb);
    }
}
