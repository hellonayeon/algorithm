class DollDrawing {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int[] basket = new int[board.length * board.length + 1]; // 인덱스 1부터 접근하기 위해
        int bIdx = 0;
        
        for(int i = 0; i < moves.length; i++) {
            
            int col = moves[i] - 1;
            
            for(int row = 0; row < board.length; row++) {
                if ( board[row][col] != 0 ) { 
                    basket[++bIdx] = board[row][col];
                    board[row][col] = 0;
                    
                    if(basket[bIdx - 1] == basket[bIdx]) { // check basket
                        answer += 2;
                        basket[bIdx - 1] = basket[bIdx] = 0;
                        bIdx -= 2;
                    }
                    
                    break;
                }  
            }
        }
        
        return answer;
    }
    
}