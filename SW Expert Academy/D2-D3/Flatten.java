import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.io.FileInputStream;

class Flatten {
    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/Flatten_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int dumpCount = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");

            int[] box = new int[100];
            for(int idx = 0; idx < box.length; idx++)
                box[idx] = Integer.parseInt(str[idx]);

            insertSort(box);
            int diff = dump(box, dumpCount);

            System.out.println("#" + tc + " " + diff);
        }

        br.close();
    }

    public static int dump(int[] arr, int dumpCount) {
        int high = arr.length-1;
        int low = 0;
        
        int diff = -1;
        while(dumpCount > 0) {
            arr[high] -= 1;
            arr[low] += 1;

            dumpCount--;

            insertSort(arr);
            diff = arr[arr.length - 1] - arr[0];
            if(diff == 0 || diff == 1) return diff;

            if(arr[high] < arr[high - 1]) high -= 1;
            if(arr[low] > arr[low + 1]) low += 1;
        }

        return diff;
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