import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

// Q2027. 대각선 출력하기
class DiagonalPrint {
    public static void main(String args[]) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write("#++++\n+#+++\n++#++\n+++#+\n++++#");
        bw.flush();
        bw.close();       
    }
}
