// 출처: https://www.pymoon.com/entry/Programmers-%EB%8B%A4%EB%A6%AC%EB%A5%BC-%EC%A7%80%EB%82%98%EB%8A%94-%ED%8A%B8%EB%9F%AD-Java

import java.util.LinkedList;
import java.util.Queue;

class Truck {
    public static void main(String[] args) {
        int bridge_length = 3;
        int weight = 10;
        int[] truck_weights = {7, 4, 3, 3, 6};
        
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>(); // 다리를 지나고 있는 트럭들의 무게 큐

        // 초기에 다리 위에는 첫 번째 트럭만 올라가 있다.
        for(int i = 0; i < truck_weights.length - 1; i++)
            bridge.add(0);

        int idx = 1; 
        int tw = truck_weights[idx]; // 다리에 올라가 있는 트럭들 무게의 합
        int sec = 1; // 모든 트럭이 다리를 지나는 데 걸린 시간
        
        if(truck_weights.length == 1) return bridge_length + 1;

        bridge.add(tw);
        while(!bridge.isEmpty()) {
            sec++; // while loop 실행되는 횟수 = 걸린 시간
            tw -= bridge.poll(); // 트럭이 한 칸 이동

            // 대기하는 트럭이 남아 있는 경우
            if(idx < truck_weights.length) {
                // 다음 트럭이 다리 위에 올라와도 무게를 초과하지 않는다면
                // 다음 트럭을 다리 위로 올린다.
                if(tw + truck_weights[idx] <= weight) {
                    tw += truck_weights[idx];
                    bridge.add(truck_weights[idx++]);
                }
                // 다음 트럭이 다리 위로 올라올 경우 무게를 초과한다면
                // 현재 다리 위에 있는 트럭들만 앞으로 이동시킨다.
                else {
                    bridge.add(0);
                }
            }  
        }
        return sec;
    }
}
