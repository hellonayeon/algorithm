import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Q8723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        
        int[] arr = new int[3];
        for(int i=0; i<arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);

        if (arr[0] == arr[1] && arr[1] == arr[2])
            bw.write("2");
        else if (arr[0]*arr[0] + arr[1]*arr[1] == arr[2]*arr[2])
            bw.write("1");
        else
            bw.write("0");
        
        bw.flush();
        bw.close();
        
    }
}