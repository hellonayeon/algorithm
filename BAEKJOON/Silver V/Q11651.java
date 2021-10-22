import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

class Q11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Coordinate> xys = new ArrayList<>();
        
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            xys.add(new Coordinate(x, y));
        }

        Collections.sort(xys);
        for(Coordinate c : xys) {
            sb.append(c).append("\n");
        }

        System.out.println(sb);
    }
}

class Coordinate implements Comparable<Coordinate> {
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coordinate c) {
        if(this.y == c.y) return this.x - c.x;
        return this.y - c.y;
    }

    @Override
    public String toString() {
        return this.x + " "  + this.y;
    }
}