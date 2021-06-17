import java.util.Arrays;

class FailureRate {
    public static void main(String[] args) {
        int N = 4;
        int[] stages = {4,4,4,4,4};
        solution(N, stages);
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        Arrays.sort(stages);

        int fail;
        double[] failure = new double[N];
        int sIdx = 0, fIdx = 0;
        int stage = 1;
        while(stage != N + 1) {
            fail = 0;

            for(; sIdx < stages.length; sIdx++) {
                if(stages[sIdx] == stage) 
                    fail++;
                else 
                    break;
            } 
            
            failure[fIdx++] = (double) fail / (stages.length - sIdx + fail);

            stage++;
        }

        System.out.println(Arrays.toString(failure));
        sort(failure, answer); 
        System.out.println(Arrays.toString(answer));
        

        return answer;
    }

    public static void sort(double[] arr, int[] ans) {

        for(int i = 0; i < ans.length; i++)
            ans[i] = i+1;

        for(int i = 1; i < arr.length; i++) {
			double element = arr[i];
            int stage = ans[i];
			
			int j = i - 1;
			
			while(j >= 0 && element > arr[j]) {
				arr[j + 1] = arr[j];
                ans[j + 1] = ans[j];
				j--;
			}

			arr[j + 1] = element;	
            ans[j + 1] = stage;
        }
    }
}
