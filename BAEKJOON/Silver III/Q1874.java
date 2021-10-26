import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] seq = new int[n];
        for(int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(seq));
    }

    public static String solution(int[] seq) {
        StringBuilder sb = new StringBuilder();

        int[] stack = new int[seq.length];
        int size = 0;

        int idx = 0, num = 1;
        while(idx < seq.length) {
            if(size != 0 && stack[size-1] == seq[idx]) {
                size--;
                sb.append("-").append("\n");

                idx++;
            }
            // 스택의 가장 위에 있는 값이
            // 나와야하는 수열의 수보다 큰 경우 수열 만족 불가능
            else if(size != 0 && stack[size-1] > seq[idx]) {
                return "NO";
            }
            else {
                stack[size++] = num++;
                sb.append("+").append("\n");
            }
        }

        return sb.toString();
    }
}
