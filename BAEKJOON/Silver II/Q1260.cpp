#include <cstdio>
#include <cstring>
#include <queue>
using namespace std;

int N;
int adj[1001][1001];
bool visit[1001];

void dfs(int vertex)
{
    visit[vertex] = true;
    printf("%d ", vertex);

    for (int i=1; i<=N; i++) {
        if(!visit[i] && adj[vertex][i]) dfs(i);
    }
}

void bfs(int vertex)
{
    queue<int> q;
    q.push(vertex);
    printf("%d ", vertex);

    visit[vertex] = true;

    int cur;
    while (!q.empty())
    {
        cur = q.front();
        for (int i=1; i<=N; i++) {
            if (!visit[i] && adj[cur][i]) {
                q.push(i);
                printf("%d ", i);
                visit[i] = true;
            }
        }
        q.pop();
    }
}

int main()
{
    int M, V, from, to;
    
    scanf("%d %d %d", &N, &M, &V);
    for (int i=0; i<M; i++) {
        scanf("%d %d", &from, &to);
        adj[from][to] = adj[to][from] = 1;
    }

    dfs(V);
    printf("\n");
    memset(visit, false, sizeof(visit));
    bfs(V);
}