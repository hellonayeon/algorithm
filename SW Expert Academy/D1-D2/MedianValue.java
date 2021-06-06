import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.io.FileInputStream;

// Q2063. 중간값 찾기
class MedianValue {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/MedianValue_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        br.close();

        int[] scores = new int[N];
        for(int i=0; i<N; i++)
            scores[i] = Integer.parseInt(str[i]);

        insertSort(scores);
        
        bw.write(String.valueOf(scores[N/2]));
        bw.flush();
        bw.close();        
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