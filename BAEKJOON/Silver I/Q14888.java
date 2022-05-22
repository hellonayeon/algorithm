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

        setOperation(0, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void setOperation(int idx, int value) {
        if (idx == N-1) {
            max = Math.max(value, max);
            min = Math.min(value, min);
            return;
        }
        
        for (int k=0; k<4; k++) {
            if (op[k] != 0) {
                op[k]--;
                setOperation(idx + 1, operate(value, nums[idx + 1], k));
                op[k]++;
            }
        }
    }

    private static int operate(int value, int next, int op) {
        if (op == 0) {
            value += next;
        }
        else if (op == 1) {
            value -= next;
        }
        else if (op == 2) {
            value *= next;
        }
        else {
            value /= next;
        }
        return value;
    }
}
