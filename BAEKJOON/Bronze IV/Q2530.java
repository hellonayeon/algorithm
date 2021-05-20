import java.io.*;
import java.util.StringTokenizer;

class Q2530 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int hour = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken());

        int cSec = Integer.parseInt(br.readLine()); // cook seconds

        int tSec = sec + cSec; // total seconds

        sec = tSec % 60;
        min += (int) (tSec / 60);
        hour += (int) (min / 60);
        min %= 60;
        hour %= 24;

        System.out.println(hour+ " " + min + " " + sec);
    }
}
