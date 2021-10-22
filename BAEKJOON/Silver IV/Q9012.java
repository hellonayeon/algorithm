import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            String input = br.readLine();

            if(vps(input)) {
                sb.append("YES").append("\n");
            }
            else { 
                sb.append("NO").append("\n");
            }
        }

        System.out.print(sb);
    }

    public static boolean vps(String str) {
        int cnt = 0;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(') cnt++;
            else cnt--;

            if(cnt < 0) return false;
        }

        return (cnt == 0) ? true: false;
    }
}

