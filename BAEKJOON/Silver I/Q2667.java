import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Q2667 {

    private static int estate = 0; // 단지 수
    private static ArrayList<Integer> houses = new ArrayList<>(); // 단지 별 집의 개수

    private static int[][] map;
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        map = new int[N + 2][N + 2]; // 각 행과 열의 가장자리에 빈 요소 추가
        visit = new boolean[N + 2][N + 2];
        for(int i = 1; i <= N; i++) {
            String input = br.readLine();
            for(int j = 1; j <= N; j++) {
                map[i][j] = input.charAt(j - 1) - '0';
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                // map을 순차적으로 탐색하던 도중 집이 있을 경우
                if(!visit[i][j] && map[i][j] == 1) {
                    estate++;
                    houses.add( search(i, j, 1) );
                }
            }
        }
        // 단지 내 집 수 오름차순 정렬
        Collections.sort(houses);

        // 단지 수 출력
        System.out.println(estate);
        // 단지 내 집 수 출력
        for(int i = 0; i < houses.size(); i++)
            System.out.println(houses.get(i));
    }

    public static int search(int row, int col, int cnt) {
        visit[row][col] = true;

        // 좌측에 집이 있는지 탐색
        if(!visit[row][col-1] && map[row][col-1] == 1) cnt = search(row, col-1, cnt+1);
        // 우측에 집이 있는지 탐색
        if(!visit[row][col+1] && map[row][col+1] == 1) cnt = search(row, col+1, cnt+1);
        // 위에 집이 있는지 탐색
        if(!visit[row-1][col] && map[row-1][col] == 1) cnt = search(row-1, col, cnt+1);
        // 아래에 집이 있는지 탐색
        if(!visit[row+1][col] && map[row+1][col] == 1) cnt = search(row+1, col, cnt+1);

        return cnt;
    }
}
