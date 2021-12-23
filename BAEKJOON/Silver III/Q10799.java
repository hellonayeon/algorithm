import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int open = 0, piece = 0;
        char pre = ' ';
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if(ch == '(') {
                open++;
            } 
            else {
                if(pre == '(') {
                    piece += --open;
                }
                else {
                    open--;
                    piece++;
                }
            }

            pre = ch;
        }

        System.out.println(piece);
    }
}