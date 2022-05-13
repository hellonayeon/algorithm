import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

import java.io.FileInputStream;

class Q4014 {

    static int N, K;
    static int[][] map;
    static int res;

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Q4014_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N * 2][N];
            for (int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < N; y++) {
                    int val = Integer.parseInt(st.nextToken());
                    map[x][y] = val;
                    map[y + N][x] = val;
                }
            }

            res = 0;
            for (int x = 0; x < N * 2; x++) {
                if(check(map[x], new boolean[N])) {
                    res += 1;
                }
            }
            sb.append("#").append(tc).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean check(int[] arr, boolean[] slope) {
        int h = arr[0];
        
        for (int y = 1; y < N; y++) {
            int ch = arr[y];
            // 이전 높이와 다르다면
            if (h != ch) {
                
                // 높이 차이가 1 보다 크면 경사로 놓기 불기능
                if (Math.abs(h - ch) > 1) {
                    return false; // 다음 행 검사
                }

                int cnt = 0;
                // 이전 높이가 더 높은 경우
                if (h > ch) {
                    // 경사로를 놓을 수 있는 K 만큼의 거리가 있는지 체크
                    for (int k = y; k < y + K && k < N; k++) {
                        int nh = arr[k];
                        if (slope[k] || nh != ch) {
                            break;
                        }

                        slope[k] = true;
                        cnt++;
                    }
                }
                // 이전 높이가 더 낮은 경우
                else {
                    // 경사로를 놓을 수 있는 K 만큼의 거리가 있는지 체크
                    int ph = arr[y-1];
                    slope[y-1] = true;
                    cnt++;
                    for (int k = y - 2; k >= y - K && k >= 0; k--) {
                        int nh = arr[k];
                        if (slope[k] || nh != ph) {
                            break;
                        }

                        slope[k] = true;
                        cnt++;
                    }
                }

                if (cnt == K) {
                    h = ch;
                }
                else {
                    return false;
                }
            } 
        }

        return true;
    }

}