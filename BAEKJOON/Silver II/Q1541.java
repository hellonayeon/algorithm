import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String formula = br.readLine();

        boolean isSub = false;
        int res = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<formula.length(); i++) {
            char ch = formula.charAt(i);

            if(ch >= '0' && ch <= '9') {
                sb.append(ch);
            }
            else {
                int num = Integer.parseInt(sb.toString());
                if(isSub) {
                    res -= num;
                }
                else if(ch == '-') {
                    res += num;
                    isSub = true;
                }
                else {
                    res += num;
                }
                sb = new StringBuilder();
            }
        }
        res += (isSub) ? Integer.parseInt(sb.toString()) * -1 : Integer.parseInt(sb.toString());

        System.out.println(res);
    }
}