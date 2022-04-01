#include <stdio.h>

int n, k, coins[11];

int main()
{
    scanf("%d %d", &n, &k);
    for (int i=0; i<n; i++) {
        scanf("%d", &coins[i]);
    }

    int res = 0;
    for (int i=n-1; i>=0; i--) {
        res += k/coins[i];
        k %= coins[i]; 
    }

    printf("%d", res);
}