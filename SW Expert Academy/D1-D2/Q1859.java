import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

import java.io.FileInputStream;
import java.math.BigInteger;

import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        System.setIn(new FileInputStream("res/1859_input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));     

		int T;
		T=Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()); // N개의 자연수
            
            int[] n = new int[N];
            for(int idx = 0; idx < N; idx++) {
            	n[idx] = Integer.parseInt(st.nextToken());
            }
            
            int max = 0, mIdx = 0 ; // max 값을 갖고있는 index
            int sIdx = 0; // 매입을 시작할 index
            BigInteger profit = new BigInteger("0");
            while(sIdx < n.length) {    
                // 최댓값 구하는 루프          
                for(int i = sIdx; i < n.length; i++) {
                    if(n[i] >= max) {
                        max = n[i];
                        mIdx = i;
                    }
                }

                // 매입, 매매 처리 루프 
                for(int i = sIdx; i < mIdx; i++) {
                    // profit -= n[i];
                    profit = profit.subtract(new BigInteger(String.valueOf(n[i])));
                }
                // profit += n[mIdx] * (mIdx - sIdx);
                
                profit = profit.add(new BigInteger(String.valueOf( (new BigInteger(String.valueOf(n[mIdx]))).multiply(new BigInteger(String.valueOf(mIdx-sIdx))))));

                sIdx = mIdx + 1;
                max = 0;
            }
            sb.append("#").append(test_case).append(" ").append(profit).append("\n");
		}
		bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}