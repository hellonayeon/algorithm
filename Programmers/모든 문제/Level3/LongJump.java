class LongJump {
    public long solution(int n) {
        int a = 0, b = 1;
        for(int i = 1; i <= n; i++) {
            int fib = (a + b) % 1234567;
            a = b;
            b = fib;
        }
        return b;
    }
}