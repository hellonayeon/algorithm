import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.io.FileInputStream;

class FactorizationIntoPrimes {

    static int[] prime = {2, 3, 5, 7, 11};

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/FactorizationIntoPrimes_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] res = new int[5];
            factorization(N, res);

            System.out.print("#" + tc + " ");
            printArr(res);
        }
    }

    public static void factorization(int N, int[] arr) {
        int idx = 0;
        while(N > 1) {
            if(N % prime[idx] == 0) {
                N /= prime[idx];
                arr[idx]++;
            }
            else idx++;
        }
    }

    public static void printArr(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
