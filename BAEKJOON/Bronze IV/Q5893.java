import java.io.*;

class Q5893 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        int[] b = new int[input.length()];
        for(int i=b.length-1; i>=0; i--)
            b[i] = input.charAt(i) - '0';

    
        int len = b.length + 5; // 17배 했을때의 이진수 길이

        int[] m = new int[len]; // 이진수 곱셈 중간과정1
        int[] n = new int[len]; // 이진수 곱셈 중간과정2
        int idx1=len-1;
        int idx2=len-5;
        for(int i=b.length-1; i>=0; i--) 
            m[idx1--] = n[idx2--] = b[i];

        int[] res = new int[len];
        for(int i=len-1; i>=0; i--) {
            if (m[i] + n[i] == 2) {
                m[i-1] += 1;
                res[i] = 0;
            }
            else if (m[i] + n[i] == 3) {
                m[i-1] += 1;
                res[i] = 1;
            }
            else {
                res[i] = m[i] + n[i];
            }
        }

        int sIdx = 0; // 0부터 출력하지 않도록 하기위해, 출력 시작 인덱스 설정
        for(int i=0; i<res.length; i++)
            if(res[i] == 0) sIdx++;
            else break;

        StringBuilder sb = new StringBuilder();
        for(int i=sIdx; i<res.length; i++)
            sb.append(res[i]);

        System.out.println(sb);
    }
}