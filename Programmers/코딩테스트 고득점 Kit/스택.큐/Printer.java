class Printer {
    public static int solution(int[] priorities, int location) {
        int ans = 0;

        for(int i = 0; i < priorities.length - 1; i++) {
            // 뒤에 있는 문서들 중에 우선순위가 높은 문서가 있는지 탐색
            int max_idx = i;
            for(int j = i+1; j < priorities.length; j++) {
                if(priorities[j] > priorities[max_idx]) max_idx = j;
            }
            // 이동이 필요한 경우
            if(max_idx != i) {
                priorities = move(priorities, ans, max_idx - i);

                // 인쇄하고자 하는 문서의 위치값 변경
                location -= max_idx - i;
                if(location < ans) location -= ans;
                if(location < 0) location += priorities.length; 
            }

            ans++;

            if(i == location) return ans;
        }

        // 마지막에 인쇄되는 경우
        return ++ans;
    }

    // 위치를 이동시킬 배열, 배열의 처음 위치, 이동시킬 칸 수
    public static int[] move(int[] arr, int rear, int move_cnt) {
        int[] tmp = new int[arr.length];
        for(int i = rear + 1; i < arr.length; i++) {
            int idx = (i + move_cnt >= arr.length) ? (i + move_cnt) % arr.length + rear : i + move_cnt;
            tmp[i] = arr[idx];
        }

        return tmp;
    }
}
