import java.io.*;

// Long.toBinaryString(Long.parseLong(br.readLine(), 2) * Long.parseLong(br.readLine(), 2));
class Q14623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String B1 = br.readLine();
        String B2 = br.readLine();

        int len = B1.length() + B2.length(); // 이진수 곱셈으로 만들어질 수 있는 이진수의 최대 길이
        
        int[] b = new int[len];
        for(int i = B2.length() - 1, shift = 1; i >= 0; i--, shift++) {   
            for(int j = B1.length() - 1, idx = len - shift; j >= 0; j--, idx--) {
                int mul = (B1.charAt(j) - '0') * (B2.charAt(i) - '0');
                int sum = b[idx] + mul;

                if(sum == 3) {
                    b[idx] = 1;
                    b[idx-1] += 1;
                }
                else if(sum == 2) {
                    b[idx] = 0;
                    b[idx-1] += 1;
                }
                else {
                    b[idx] = sum;
                }
            }
        }

        int sIdx;
        for(sIdx = 0; sIdx < len; sIdx++) {
            if(b[sIdx] == 1) break;
        }

        StringBuilder sb = new StringBuilder();
        for(; sIdx < len; sIdx++) {
            sb.append(b[sIdx]);
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}