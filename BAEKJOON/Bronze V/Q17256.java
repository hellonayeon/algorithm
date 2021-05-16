import java.io.*;
import java.util.StringTokenizer;

class Q17256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr1 = br.readLine().split(" "); 
        String[] arr2 = br.readLine().split(" "); 
        
        // 케이크 수 a를 구성하는 자연수
        int ax = Integer.parseInt(arr1[0]);
        int ay = Integer.parseInt(arr1[1]);
        int az = Integer.parseInt(arr1[2]);
        
        // 케이크 수 c를 구성하는 자연수
        int cx = Integer.parseInt(arr2[0]);
        int cy = Integer.parseInt(arr2[1]);
        int cz = Integer.parseInt(arr2[2]);
        
        // 케이크 수 b를 구성하는 자연수
        int bx = cx - az;
        int by = cy / ay;
        int bz = cz - ax;
        
        System.out.print( bx + " " + by + " " + bz );
    }
}