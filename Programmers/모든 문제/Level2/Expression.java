// 정수론 
// "주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수는 주어진 수의 홀수 약수의 개수와 같다"

class Expression {
    public int solution(int n) {
        int ans = 0;
        for(int i = 1; i <= n; i+=2)
            if(n % i == 0) ans++;
        
        return ans;
    }
}