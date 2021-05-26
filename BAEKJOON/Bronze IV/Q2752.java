import java.io.*;
import java.util.StringTokenizer;

class Q2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[3];

        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());
        
        // inset sort
        insertSort(arr);        

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++)
            sb.append(arr[i]).append(" ");

        System.out.println(sb);
    }

    public static void selectionSort(int[] arr) {
        int minIdx, temp;
        for(int i=0; i<arr.length-1; i++) {
            minIdx = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
			int element = arr[i];
			
			int j = i - 1;
			
			while(j >= 0 && element < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}

			arr[j + 1] = element;	
        }
    }
}