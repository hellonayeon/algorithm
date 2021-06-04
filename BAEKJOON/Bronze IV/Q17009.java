import java.io.*;

class Q17009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int aScore = 0;
        for(int i=3; i>0; i--)
            aScore += Integer.parseInt(br.readLine()) * i ;
        
        int bScore = 0;
        for(int i=3; i>0; i--)
            bScore += Integer.parseInt(br.readLine()) * i ;
        
        br.close();
        
        if(aScore > bScore)
            bw.write("A");
        else if(aScore < bScore)
            bw.write("B");
        else
            bw.write("T");
        
        bw.flush();
        bw.close();
    }
}