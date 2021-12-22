import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.PriorityQueue;

class Q11650 {

    static class Point implements Comparable<Point> {

        int x;
        int y;

        public Point(int x,  int y) {
            this.x = x; 
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return (this.x != o.x) ? this.x - o.x : this.y - o.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Point p = pq.poll();
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }

        System.out.print(sb);
    }
}
