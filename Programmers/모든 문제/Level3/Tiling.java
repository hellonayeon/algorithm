// 굳이 arr를 사용해서 메모리 할당할 필요 X
class Tiling {
    public int solution(int n) {
        int a = 0, b = 1;
        for(int i = 0; i < n; i++) {
            int fib = (a+b) % 1000000007;
            a = b;
            b = fib;
        }
        return b;
    }
}