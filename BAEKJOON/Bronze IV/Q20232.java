import java.io.*;

class Q20232 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] winners = {"ITMO", "SPbSU", "SPbSU", "ITMO", "ITMO", "SPbSU", "ITMO", "ITMO", "ITMO", "ITMO", 
                            "ITMO", "PetrSU, ITMO", "SPbSU", "SPbSU", "ITMO", "ITMO", "ITMO", "ITMO", "SPbSU", "ITMO", 
                            "ITMO", "ITMO", "ITMO", "SPbSU", "ITMO"};

        int y = Integer.parseInt(br.readLine());
        br.close();

        bw.write(winners[y-1995]);
        bw.flush();
        bw.close();       
    }
}