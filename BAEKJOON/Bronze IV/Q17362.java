import java.io.*;

// 출처: https://jaimemin.tistory.com/1369 [꾸준함]
class Q17362 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
        int n = Integer.parseInt(br.readLine());
        br.close();

        if (n <= 5) { 
            System.out.println(n);
            return;
        } 

        while (n > 5) { 
            n -= 8; 
        } 
        
        int res = n; 
        if (res <= 0) { 
            res = 2 + (res * -1); 
        }

        System.out.println(res);     
    }
}