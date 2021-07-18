// 맨해튼 거리가 2 이하인 경우만 확인

class Distancing {
    
    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};
    
    public int[] solution(String[][] places) {
        int[] ans = new int[5];
        
        for(int i = 0; i < 5; i++) ans[i] = 1;
        
        for(int p = 0; p < 5; p++) {
            
            boolean distancing = true;
            boolean[][] visit = new boolean[5][5];
            
            for(int y = 0; y < 5; y++) {
                for(int x = 0; x < 5; x++) {
                    if(places[p][y].charAt(x) == 'P' && !check(places[p], visit, x, y, 0)) {
                        distancing = false;
                        break;
                    }       
                }
                if(!distancing) { 
                    ans[p] = 0;
                    break;
                }
            }
        }
        
        return ans;
    }
    
    public boolean check(String[] place, boolean[][] visit, int x, int y, int dis) {
        if(dis == 2) return true;
        visit[y][x] = true;
        
        for(int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            
            if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            if(!visit[ny][nx] && place[ny].charAt(nx) != 'X') { 
                if(place[ny].charAt(nx) == 'P' || !check(place, visit, nx, ny, dis + 1)) return false;
            }
        }
        
        return true;
    }
}