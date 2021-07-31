class BiggestSquare
{   
    public int solution(int[][] board) {
        // 행 또는 열의 크기가 1인 경우
        // 만들 수 있는 가장 큰 정사각형의 넓이는 1
        if(board.length == 1 || board[0].length == 1) return 1;
        
        int ans = 0;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] > 0) {                    
                    // 위 , 좌 , 좌측 대각선 값을 찾아 그중 최소값 + 1 로 업데이트
                    int up = board[i-1][j];
                    int left = board[i][j-1];
                    int diagonal = board[i-1][j-1];
                    
                    board[i][j] = Math.min(Math.min(up, left), diagonal) + 1;

                    ans = Math.max(ans, board[i][j]);
                }
            }
        }

        return ans * ans;
    }
}