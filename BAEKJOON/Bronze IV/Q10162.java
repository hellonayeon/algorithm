import java.io.*;

class Q10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        br.close();

        if(T % 10 != 0) {
            System.out.println("-1");
            return;
        }

        int[] btn = {300, 60, 10};
        int[] count = new int[3];
        
        for(int i=0; i<btn.length; i++) {
            count[i] = T/btn[i];
            T -= (btn[i] * count[i]);
        }

        for(int i=0; i<btn.length; i++)
            System.out.print(count[i] + " ");
    }
}