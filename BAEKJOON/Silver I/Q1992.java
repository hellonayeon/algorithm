import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Q1992 {
    
    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder(); // 영상 압축 결과 문자열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int r = 0; r < N; r++) {
            String str = br.readLine();
            for(int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c) - '0';
            }
        }

        compress(0, 0, N, N);

        System.out.println(sb);
    }  
    
    public static void compress(int sr, int sc, int er, int ec) {
        int val = map[sr][sc];
        if(compare(val, sr, sc, er, ec)) {
            sb.append(val);
            return;
        }

        // 현재 위치에서 얼마나 이동할 것인지 계산
        int mr = sr+(er-sr)/2;
		int mc = sc+(ec-sc)/2;
		
        sb.append('(');
		
        compress(sr,sc,mr,mc); // 왼쪽 위
		compress(sr,mc,mr,ec); // 오른쪽 위
		compress(mr,sc,er,mc); // 왼쪽 아래
		compress(mr,mc,er,ec); // 오른쪽 아래
        
        sb.append(')');
    }

    public static boolean compare(int val, int sr, int sc, int er, int ec) {
        for(int r = sr; r < er; r++) {
            for(int c = sc; c < ec; c++) {
                if(map[r][c] != val) return false;
            }
        }
        return true;
    }
}
