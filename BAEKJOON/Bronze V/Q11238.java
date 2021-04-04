import java.io.*;

class Q11283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char hangeul = br.readLine().charAt(0);

        System.out.println(( (int)hangeul) - 44031 );
    }
}
