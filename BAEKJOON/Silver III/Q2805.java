// 출처: [백준] 2805번 : 나무 자르기 - JAVA [자바] https://st-lab.tistory.com/270

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

class Q2805 {
    public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] tree = new int[N];
		
		int min = 0;
		int max = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(max < tree[i]) {
				max = tree[i];
			}
            if(min > tree[i]) {
                min = tree[i];
            }
		}
		
		while(min < max) {
			int mid = (min + max) / 2;
			long sum = cut(tree, mid);
			
			if(sum < M) {
				max = mid;
			}
			else {
				min = mid + 1;
			}
		}
		
		System.out.println(min - 1);
		
	}

    public static int cut(int[] tree, int mid) {
        int sum = 0;
        for(int height : tree) {
            if(height - mid > 0) { 
                sum += (height - mid);
            }
        }
        return sum;
    }
}