import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2630 {
	
	static int N;
	static int[][] map;
	static int[] count = new int[2];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j<<1) - '0'; // 입력행이 숫자 + 공백 + 숫자 + 공백 ... 형식이라 공백을 건너 뛰기 위해 쉬프트 연산 수행
			}
		}
		cut(0,0,N);
		System.out.println(count[0]);
		System.out.println(count[1]);
	}

	public static void cut(int r, int c, int n) {
		int compare = map[r][c]; // 첫번째 원소랑 다른 원소들의 종이 색 비교 (compare = 0 또는 compare = 1)
		boolean isSame = true;
		for(int i = r; i < r+n; i++) { // start row - end row
			for(int j = c; j < c+n; j++) { // start col - end col
				if(map[i][j] != compare) {
					isSame = false;
				}
			}
		}
		if(isSame) {
			count[compare]++;
			return;
		}
		
		cut(r, c, n/2);
		cut(r, c+n/2, n/2);
		cut(r+n/2, c, n/2);
		cut(r+n/2, c+n/2, n/2);
	}
}