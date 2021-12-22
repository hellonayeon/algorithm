import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Q11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Coordinate> coordinates = new ArrayList<>();

        while(N-- > 0) {
            String[] xy = br.readLine().split(" ");
            coordinates.add(new Coordinate(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])));
        }

        Collections.sort(coordinates);

        StringBuilder sb = new StringBuilder();
        for(Coordinate cor : coordinates) {
            sb.append(cor.x).append(" ").append(cor.y).append("\n");
        }

        System.out.print(sb);
    }

    static class Coordinate implements Comparable<Coordinate>{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o) {
            return (this.x == o.x) ? this.y - o.y : this.x - o.x;
        }
    }
}
