import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q1011 {

    public static int dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            
            dis = Integer.MAX_VALUE; // 2^32 = 2,147,483,648
            move(x+1, y-1, 1, 1);

            sb.append(dis).append("\n");
        }

        System.out.println(sb);
    }

    public static void move(long x, long y, int k, int cnt) {
        if(x > y) return;
        if(x == y) {
            // y지점에 도착하기 바로 직전의 이동거리가 반드시 1광년이 되기 위해
            // 현재 지점에 도착하기까지 걸린 광년이 1 또는 2 가 되어야 한다.
            if(k == 1 || k == 2) {
                dis = (++cnt < dis) ? cnt : dis;
            }
            return;
        }

        move(x + k+1, y, k+1, cnt+1);
        move(x + k, y, k, cnt+1);
        if(k-1 > 0) move(x + k-1, y, k-1, cnt+1);
    }
}