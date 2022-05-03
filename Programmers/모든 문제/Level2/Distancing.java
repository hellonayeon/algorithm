import java.util.Arrays;

class Distancing {
    
    int size = 5;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int res;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[size];
        Arrays.fill(answer, 1);
        
        for (int room = 0; room < size; room++) {
            res = 1;
            for (int x = 0; x < size; x++) {
                String row = places[room][x];
                for (int y = 0; y < size; y++) {
                    char c = row.charAt(y);
                    
                    if (c == 'P') {
                        boolean[][] visit = new boolean[size][size];
                        visit[x][y] = true;
                        checkDistance(places[room], x, y, 0, visit, false);
                        answer[room] = res;
                    }
                }
            }
        }
        
        
        return answer;
    }
    
    private void checkDistance(String[] place, int cx, int cy, int dis, boolean[][] visit, boolean partition) {
        if (dis != 0 && place[cx].charAt(cy) == 'P') {
            if (dis > 2 || (dis <= 2 && partition)) {
                return;
            }
            res = 0;
            return;
        }
        
        if (place[cx].charAt(cy) == 'X') {
            partition = true;
        }
        
        for (int k=0; k<4; k++) {
            int nx = cx + dx[k];
            int ny = cy + dy[k];
            
            if (nx < 0 || ny < 0 || nx >= size || ny >= size || visit[nx][ny]) {
                continue;
            }
            
            visit[nx][ny] = true;
            checkDistance(place, nx, ny, dis + 1, visit, partition);
            visit[nx][ny] = false;
        }
    }
}