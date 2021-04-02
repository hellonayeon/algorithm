import java.io.*;
import java.util.StringTokenizer;

// 코드 가독성을 위해 어느정도의 변수 선언은 권장
//
// StringTokenizer 대신 String[] 와 split() 을 이용하는 방법
// StringBuilder 를 이용해 결과 출력하는 방법

class Q2845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer stk1 = new StringTokenizer(br.readLine()); // input L, P
        StringTokenizer stk2 = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(stk1.nextToken()) * Integer.parseInt(stk1.nextToken());
        while(stk2.hasMoreTokens())
            System.out.print( (Integer.parseInt(stk2.nextToken()) - count) + " " );

    }
}