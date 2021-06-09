// 출처: https://codepractice.tistory.com/81 [코딩 연습]

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.io.FileInputStream;

class Snail {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Snail_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] snail = new int[N][N];
            makeArr(N, snail);

            System.out.println("#" + tc);
            printArr(N, snail);
        }
    }

    public static void makeArr(int go, int[][] arr) {
        int value = 0;
        int row = 0, col = -1;
        int inc = 1;

        while(true) {
            for(int i = 0; i < go; i++) {
                col += inc;
                arr[row][col] = ++value;
            }
            go--;

            if(go == 0) break;

            for(int i = 0; i < go; i++) {
                row += inc;
                arr[row][col] = ++value;
            }

            inc *= -1;
        }
    }

    public static void printArr(int n, int[][] arr) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}