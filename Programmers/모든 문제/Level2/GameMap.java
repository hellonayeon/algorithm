import java.util.Queue;
import java.util.LinkedList;

class Position {
    int x;
    int y;
    int dis;
    
    public Position(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

class GameMap {
    
    private int row; // 게임 맵 사이즈
    private int col;
    
    private int[][] maps;
    private boolean[][] visit;
    
    private int shortest_dis = 0; // 최단 거리
    
    private int[][] mv = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} }; // 상하좌우 좌표
    
    public int solution(int[][] maps) {
        this.row = maps.length;
        this.col = maps[0].length;
        
        this.maps = maps;
        this.visit = new boolean[row][col];
        this.shortest_dis = row * col;
        
        // 방문 배열에 벽이 있는 자리 표시
        for(int r = 0; r < row; r++) {
            for(int c = 0; c < col; c++) {
                if(maps[r][c] == 0) visit[r][c] = true;
            }
        }
        
        move(new Position(0, 0, 1));
        
        return (visit[row-1][col-1] == true) ? shortest_dis : -1;
    }
    
    public void move(Position pos) {
        visit[pos.y][pos.x] = true;
        
        Queue<Position> queue = new LinkedList<>();
        queue.offer(pos);
        
        while(!queue.isEmpty()) {
            Position cpos = queue.poll();
            
            int x = cpos.x;
            int y = cpos.y;
            
            for(int k = 0; k < mv.length; k++) {
                int nx = x + mv[k][0];
                int ny = y + mv[k][1];
                
                // 게임 맵의 범위를 벗어난 경우
                if(nx < 0 || nx >= col || ny < 0 || ny >= row) continue;
                
                // 상대팀 진영에 도달한 경우
                if(nx == col - 1 && ny == row - 1) {
                    visit[ny][nx] = true;
                    shortest_dis = (cpos.dis + 1 <= shortest_dis) ? cpos.dis + 1 : shortest_dis;
                    return;
                }
                
                if(!visit[ny][nx] && maps[ny][nx] == 1) {
                    visit[ny][nx] = true;
                    queue.offer(new Position(nx, ny, cpos.dis + 1));
                }
            }
        }
    }
}