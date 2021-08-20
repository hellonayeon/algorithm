class CompressQuadtree {
    
    int[] cnt = new int[2]; // 0과 1의 개수
    
    public int[] solution(int[][] arr) {
        divide(arr, 0, 0, arr.length, arr.length);
        
        return cnt;
    }
    
    public void divide(int[][] arr, int sr, int sc, int er, int ec) {
        int val = arr[sr][sc]; // 첫 번째 값을 기준으로 영역 내부의 수가 같은지 체크
        if(compare(arr, val, sr, sc, er, ec)) {
            cnt[val]++;
            return;
        }
            
        int range = (er - sr)/2;
        for(int r = sr; r < er; r+=range) {
            for(int c = sc; c < ec; c+=range) {
                divide(arr, r, c, r + range, c + range);
            }
        }
    }
    
    public boolean compare(int[][] arr, int val, int sr, int sc, int er, int ec) {
        for(int r = sr; r < er; r++) {
            for(int c = sc; c < ec; c++) {
                if(arr[r][c] != val) return false;
            }
        }
        return true;
    }
}