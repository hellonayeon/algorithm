class Q3_1 {
    public static void main(String[] args) {
        int[] coinTypes = {500, 100, 50, 10};
        int N = 1260;
        
        int cnt = 0;
        for(int i=0; i<4; i++) {
            int coin = coinTypes[i];
            cnt += N / coin;
            N %= coin;
        }

        System.out.println(cnt);
    }
}