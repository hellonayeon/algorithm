import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Q1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String formula = br.readLine();

        // '-' 기준으로 자르기
        StringTokenizer tokens = new StringTokenizer(formula, "-");
        StringTokenizer first = new StringTokenizer(tokens.nextToken(), "+");

        int res = 0;
        while(first.hasMoreTokens()) {
            res += Integer.parseInt(first.nextToken());
        }

        while(tokens.hasMoreTokens()) {
            StringTokenizer token = new StringTokenizer(tokens.nextToken(), "+");

            while(token.hasMoreTokens()) {
                res -= Integer.parseInt(token.nextToken());
            }
        }

        System.out.println(res);
    }
}