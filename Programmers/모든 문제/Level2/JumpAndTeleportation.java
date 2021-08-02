class JumpAndTeleportation {
    public int solution(int n) {
        return move(n, 0);
    }
    
    public int move(int n, int battery) {
        if(n == 0) return battery;
        
        // 점프
        if(n % 2 == 0) return move(n/2, battery);
        // 순간 이동
        else return move(n - 1, battery + 1);
    }
}