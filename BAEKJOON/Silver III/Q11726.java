import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int len = n+2;
        int[] arr = new int[len];
        arr[1] = 1;

        for(int i = 2; i < len; i++) {
            arr[i] = (arr[i-1] + arr[i-2]) % 10007;
        }

        System.out.println(arr[len-1]);
    }
}