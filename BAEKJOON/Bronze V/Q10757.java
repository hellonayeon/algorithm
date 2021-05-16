import java.io.*;
import java.util.StringTokenizer;
 
class Q10757 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String strA = st.nextToken();
		String strB = st.nextToken();
		
		int maxLen = Math.max(strA.length(), strB.length());
			
        
		int[] A = new int[maxLen + 1];	// 마지막 자리수 올림이 있을 수 있으므로 +1
		int[] B = new int[maxLen + 1];	
		
		// A 초기화 
		for(int i = strA.length() - 1, idx = 0; i >= 0; i--, idx++) {
			A[idx] = strA.charAt(i) - '0';
		}
		
		// B 초기화
		for(int i = strB.length() - 1, idx = 0; i >= 0; i--, idx++) {
			B[idx] = strB.charAt(i) - '0';
		}
		
		
		for(int i = 0; i < maxLen; i++) {
			int value = A[i] + B[i];
			A[i] = value % 10;
			A[i + 1] += (value / 10);
		}

		StringBuilder sb = new StringBuilder();
		if(A[maxLen] != 0) {
			sb.append(A[maxLen]);
		}
		
		for(int i = maxLen - 1; i >= 0; i--) {
			sb.append(A[i]);
		}
		System.out.println(sb);
	}
}