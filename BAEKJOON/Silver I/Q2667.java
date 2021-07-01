import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Queue;
import java.util.LinkedList;

class Q2667 {

    private static int N; // 지도의 크기

    private static int estate = 0; // 단지 수
    private static ArrayList<Integer> houses = new ArrayList<>(); // 단지 별 집의 개수

    private static int[][] loc = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} }; // 집의 상하좌우로 인접한 집이 있는지 확인하기 위한 변수

    private static int[][] map; // 지도
    private static boolean[][] visit; // 집의 방문 여부 체크 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        map = new int[N][N]; // 각 행과 열의 가장자리에 빈 요소 추가
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // map을 순차적으로 탐색하던 도중 집이 있을 경우
                if(!visit[i][j] && map[i][j] == 1) {
                    estate++;
                    houses.add( bfs(i, j) );
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

    public static int bfs(int row, int col) {
        int house_cnt = 0; // 단지 내 집의 개수

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        visit[row][col] = true;
        house_cnt++;

        while(!queue.isEmpty()) {
            int[] house_loc = queue.poll(); // 탐색을 시작하는 기준 집
            int cur_row = house_loc[0];
            int cur_col = house_loc[1];

            // 기준 집의 상하좌우로 인접한 집이 있는지 체크
            for(int i = 0; i < loc.length; i++) {
                int next_row = cur_row + loc[i][0];
                int next_col = cur_col + loc[i][1];
                
                // 검사하려는 집의 위치가, 지도에서 벗어 나는지 체크
                if(next_row < 0 || next_row >= N || next_col < 0 || next_col >= N) continue;
                // 이미 검사한 집인지 체크
                if (visit[next_row][next_col]) continue;
                // 인접한 곳에 집이 있는지 체크
                if (map[next_row][next_col] == 0) continue;
                // 인접한 위치에 집이 있다면, 다음 집을 기준으로 체크
                visit[next_row][next_col] = true;
                house_cnt++;

                queue.offer(new int[] { next_row, next_col });

            }
        }
        return house_cnt;
    }
}
