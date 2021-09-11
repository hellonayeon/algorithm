import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder[] ageSb = new StringBuilder[201];
        for(int i = 0; i < 201; i++)
            ageSb[i] = new StringBuilder();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            ageSb[age].append(age).append(" ").append(st.nextToken()).append("\n");
        }

        StringBuilder ans = new StringBuilder();
        for(StringBuilder sb : ageSb) {
            ans.append(sb);
        }

        System.out.println(ans);
    }
}