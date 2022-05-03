import java.util.Arrays;

class Solution {
        
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    boolean[][] visit;
    int[] answer;
    
    public int[] solution(String[][] places) {
        visit = new boolean[5][5];
        answer = new int[5];
        Arrays.fill(answer, 1);
        
        for (int room = 0; room < 5; room++) {
            
            for (int x = 0; x < 5; x++) {
                String row = places[room][x];
                
                for (int y = 0; y < 5; y++) {
                    char c = row.charAt(y);
                    
                    if (c == 'P') {
                        visit[x][y] = true;
                        checkDistance(places[room], room, x, y, 0);
                        visit[x][y] = false;
                    }
                }
            }
        }
        
        
        return answer;
    }
    
    private void checkDistance(String[] place, int room, int cx, int cy, int dis) {
        // 거리가 3이상 되면 조건을 이미 만족하므로 리턴
        if (dis > 2) return;
        if (place[cx].charAt(cy) == 'P' && dis > 0 && dis <= 2) {
            answer[room] = 0;
        }
        
        for (int k=0; k<4; k++) {
            int nx = cx + dx[k];
            int ny = cy + dy[k];
            
            // 다음 위치가 파티션인 경우 방문하지 않기
            // P to P 로 가는 길에 파티션이 있으면 거리두기가 성립
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && place[nx].charAt(ny) != 'X') {
                if (!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    checkDistance(place, room, nx, ny, dis + 1);
                    visit[nx][ny] = false;
                }
            }
        }
    }
}