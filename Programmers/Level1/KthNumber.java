import java.util.Arrays;

public class KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            int[] tmp = new int[commands[i][1] - commands[i][0] + 1];

            for(int j = commands[i][0] - 1, idx = 0; j <= commands[i][1] - 1; j++)
                tmp[idx++] = array[j];

            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2] -1];
        }

        return answer;
    }
}
