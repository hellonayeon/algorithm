// [출처] [백준] 15681번 - "트리와 쿼리" (Java), https://bbangson.tistory.com/54

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.ArrayList;

class Q15681 {

    static ArrayList<Integer>[] list, tree;
    static int parent[], size[];

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        size = new int[N+1];
        list = new ArrayList[N+1];
        tree = new ArrayList[N+1];

        for (int i=0; i<list.length; i++) {
            list[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for (int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            list[U].add(V);
            list[V].add(U);
        }

        makeTree(R, -1);
        countSubtreeNodes(R);

        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            int query = Integer.parseInt(br.readLine());
            sb.append(size[query]).append("\n");
        }
        System.out.println(sb);
    }

    // 현재 노드 = 부모노드, 현재 노드와 연결된 다른 노드들 = 자식노드
    // 현재 노드와 연결되어 있는 노드들을 자식 노드로 삽입
    public static void makeTree(int curNode, int p) {
        for (int node : list[curNode]) {
            // 양방향으로 연결했으니, 부모-자식 연결관계 총 2개
            // 부모노드로 다시 돌아가지 않도록, 부모노드는 생략
            if (node != p) {
                tree[curNode].add(node);
                parent[node] = curNode; // 현재노드에 대한 부모노드 정보 저장
                makeTree(node, curNode);
            }
        }
    }

    public static void countSubtreeNodes(int curNode) {
        size[curNode] = 1; // 서브트리에 속한 정점은 자기 자신도 포함

        for (int node : tree[curNode]) {
            countSubtreeNodes(node);
            size[curNode] += size[node];
        }
    }
}
