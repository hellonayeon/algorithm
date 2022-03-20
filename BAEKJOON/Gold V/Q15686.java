import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.List;
import java.util.ArrayList;

class Q15686 {

    static int N;
    static int M;
    static List<Location> houses;
    static List<Location> franchise;
    static boolean[] visited;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        houses = new ArrayList<>();
        franchise = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());

                if (val == 1) {
                    houses.add(new Location(i, j));
                } else if (val == 2) {
                    franchise.add(new Location(i, j));
                }
            }
        }
        visited = new boolean[franchise.size()];

        calcChickenDist(0, 0);
        System.out.println(min);
    }

    static void calcChickenDist(int depth, int idx) {
        if (depth == M) {
            int total = 0;
            for (int i = 0; i < houses.size(); i++) {
                int dist = Integer.MAX_VALUE;
                for (int j = 0; j < franchise.size(); j++) {
                    if (visited[j]) {
                        dist = Math.min(Math.abs(franchise.get(j).r - houses.get(i).r) + Math.abs(franchise.get(j).c - houses.get(i).c), dist);
                    }

                }
                total += dist;
            }
            min = Math.min(total, min);

            return;
        }

        for (int i = idx; i < franchise.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                calcChickenDist(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static class Location {
        int r;
        int c;

        public Location(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}