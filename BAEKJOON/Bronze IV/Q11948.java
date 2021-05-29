import java.io.*;

class Q11948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());
        br.close();
        
        int res = Math.max(E, F);
        res += (A + B + C + D) - Math.min(Math.min(Math.min(A, B), C), D);
        
        bw.write(Integer.toString(res));
        bw.flush();
        bw.close();
    }
    
    // 삽입정렬 내림차순
    public static void insertSort(int[] arr) {
        for(int i=arr.length-2; i>=0; i--){
            int elem = arr[i];
            
            int j = i + 1;
            while(j < arr.length && arr[j] > elem) {
                arr[j - 1] = arr[j];
                j++;
            }
            
            arr[j-1] = elem;
        }
    }
}