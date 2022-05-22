import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q14888 {

    static int N;
    static int[] nums;
    static int[] op;
    static int max = -1000000000;
    static int min = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        op = new int[4];
        for (int i=0; i<4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        setOperation(0, new int[N-1]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void setOperation(int idx, int[] opComb) {
        if (idx == N-1) {
            operate(opComb);
            return;
        }
        
        for (int k=0; k<4; k++) {
            if (op[k] != 0) {
                op[k] -= 1;
                opComb[idx] = k;
                setOperation(idx + 1, opComb);
                op[k]++;
            }
        }
    }

    private static void operate(int[] opComb) {
        int res = nums[0];
        int nidx = 1;
        for (int i=0; i<N-1; i++, nidx++) {
            if (opComb[i] == 0) {
                res += nums[nidx];
            }
            else if (opComb[i] == 1) {
                res -= nums[nidx];
            }
            else if (opComb[i] == 2) {
                res *= nums[nidx];
            }
            else {
                res /= nums[nidx];
            }
        }

        max = Math.max(res, max);
        min = Math.min(res, min);
    }
}
