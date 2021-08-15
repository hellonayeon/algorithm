import java.util.Stack;

class NRadixGame {
    static char[] numeralSystem = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    public String solution(int n, int t, int m, int p) {
        char[] sequence = new char[t * m];
        Stack<Character> stack = new Stack<>();
        int count = 0; // 현재 구하는 번째 (squence index)
        int number = 0, temp = number; // number는 차례대로 증가하는 수(진법 변환시킬 숫자), temp는 나눗셈 나머지 연산을 위한 변수
        int limit = m * t; // 구해야 하는 숫자들의 개수 (참가자 X 구해야하는 숫자 개수)

        while (count < limit) {
            if (temp < n) {
                sequence[count++] = numeralSystem[temp];
                while (!stack.isEmpty() && count < limit) {
                    sequence[count++] = stack.pop();
                }
                temp = ++number;
            } else {
                stack.push(numeralSystem[temp % n]);
                temp /= n;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = p - 1; i < sequence.length; i += m) {
            sb.append(sequence[i]);
        }
        
        return sb.toString();
    }
}