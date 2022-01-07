import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q2 {

    static int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
    static int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int x = input.charAt(0) - 96;
        int y = input.charAt(1) - '0';

        int cnt = 0;
        for(int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 1 || nx > 8 || ny < 1 || ny > 8) continue;
            
            cnt++;
        }

        System.out.println(cnt);
    }
}