#include <cstdio>

int main()
{
    int N, K;
    scanf("%d %d", &N, &K);
    
    int coins[N];
    for (int i=0; i<N; i++) {
        scanf("%d", &coins[i]);
    }

    int ans = 0;
    for (int i=N-1; i>=0; i--) {
        if (coins[i] <= K) {
            int cnt = K / coins[i];
            K -= coins[i] * cnt;
            ans += cnt;
        }
    }

    printf("%d\n", ans);
}