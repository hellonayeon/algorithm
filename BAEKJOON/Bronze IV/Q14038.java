import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int win=0;
        for(int i=0; i<6; i++)
            if(br.readLine().equals("W")) win++; 
        
        br.close();
        
        if(win >= 5)
            bw.write("1");
        else if(win >= 3)
            bw.write("2");
        else if(win >= 1)
            bw.write("3");
        else
            bw.write("-1");
        
        bw.flush();
        bw.close();
    }
}