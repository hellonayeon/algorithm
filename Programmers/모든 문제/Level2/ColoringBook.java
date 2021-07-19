import java.util.Queue;
import java.util.LinkedList;

class ColoringBook {
    
    boolean[][] v;

    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};
    
    int numberOfArea = 0;
    int maxSize = 0;
    
    public int[] solution(int m, int n, int[][] picture) {
        v = new boolean[m][n];
        
        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                if(!v[y][x] && picture[y][x] != 0) { 
                    v[y][x] = true;
                    int size = checkArea(picture, picture[y][x], x, y, m, n, 1);
                    
                    numberOfArea++;
                    maxSize = (size > maxSize) ? size : maxSize;
                }
            }
        }
        return new int[]{numberOfArea, maxSize};
    }
    
    public int checkArea(int[][] picture, int area, int x, int y, int h, int w, int size) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            
            for(int k = 0; k < 4; k++) {
                int nx = pos[0] + dx[k];
                int ny = pos[1] + dy[k];
                
                if(nx < 0 || nx >= w || ny < 0 || ny >= h) continue;
                if(!v[ny][nx] && picture[ny][nx] == area) {
                    v[ny][nx] = true;
                    size++;
                    queue.offer(new int[]{nx, ny});
                }
            } 
        }
        return size;
    }
}