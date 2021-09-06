import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str;
        int T = 0;
        StringBuilder sb = new StringBuilder();
        while(!(str = br.readLine()).equals("0 0 0")) {
            String[] nums = str.split(" ");
            int L = Integer.parseInt(nums[0]);
            int P = Integer.parseInt(nums[1]);
            int V = Integer.parseInt(nums[2]);

            int day = (V/P) * L;
            day += (V%P <= L) ? V % P : L; // 남은 휴가 기간보다 캠핑장 이용 가능한 날의 수가 적을 수 있다.

            sb.append("Case ").append(++T).append(": ").append(day).append("\n");
        }

        System.out.print(sb);
    }
}