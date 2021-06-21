import java.util.ArrayList;

class FeatureDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();

        int[] days = new int[progresses.length]; // 배포까지 걸리는 일 수
        for(int i = 0; i < days.length; i++) {
            int progress = progresses[i];
            while(progress < 100) {
                progress += speeds[i];
                days[i]++;
            }
        }

        int count = 1;
        int day = days[0];
        for(int i = 1; i < days.length; i++) {
            if(days[i] <= day) count++;
            else {
                list.add(count);
                count = 1;
                day = days[i];
            }
        }
        list.add(count);

        // list to int arr
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);

        return ans;
    }
}