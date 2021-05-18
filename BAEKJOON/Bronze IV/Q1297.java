import java.io.*;
import java.util.StringTokenizer;

class Q1297 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int diag = Integer.parseInt(st.nextToken());
		int hRatio = Integer.parseInt(st.nextToken());
		int wRatio = Integer.parseInt(st.nextToken());
        
		double res = Math.sqrt( Math.pow(diag,2) / (Math.pow(hRatio,2)+Math.pow(wRatio,2)) );

		System.out.print( (int)Math.floor(res*hRatio)+ " " + (int)Math.floor(res*wRatio));
	}
}