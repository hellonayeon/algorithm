class NextBigNumber {
    public int solution(int n) {
        int ncnt = bitCount(n);
        while(true) {
            if(bitCount(++n) == ncnt) return n;
        }
    }
    
    public int bitCount(int n) {
        int cnt = 0;
        while(n > 0) {
            if(n % 2 == 1) cnt++;
            n /= 2;
        }
        return cnt;
    }
}