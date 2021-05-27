import java.io.*;

class Q6764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int sound1 = Integer.parseInt(br.readLine());
        int sound2 = Integer.parseInt(br.readLine());
        int sound3 = Integer.parseInt(br.readLine());
        int sound4 = Integer.parseInt(br.readLine());
        
        br.close();
        
        if(sound1 < sound2 && sound2 < sound3 && sound3 < sound4)
            bw.write("Fish Rising");
        else if(sound1 > sound2 && sound2 > sound3 && sound3 > sound4)
            bw.write("Fish Diving");
        else if(sound1 == sound2 && sound2 == sound3 && sound3 == sound4)
            bw.write("Fish At Constant Depth");
        else
            bw.write("No Fish");
        
        bw.flush();
        bw.close();
    }
}