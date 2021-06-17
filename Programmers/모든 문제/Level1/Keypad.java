public class Keypad {

    public static void main(String[] args) {
        int[] numbers = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
        String hand = "left";

        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        char[][] keypad = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'},
            {'*', '0', '#'}
        };

        char lPos = '*', rPos = '#';
        for(int i = 0; i < numbers.length; i++) {
            char push = (char)(numbers[i] + '0');
            
            if (push == '1' || push == '4' || push == '7') {
                lPos = push;
                answer += "L";
            }
            else if (push == '3' || push == '6' || push == '9') {
                rPos = push;
                answer += "R";
            }
            else { // 2, 5, 8, 0 을 눌러야 하는 경우
                int lDis = 0, rDis = 0;

                int row;

                // 왼손이 갈 수 있는 최단거리 찾기
                if(lPos == '1' || lPos == '4' || lPos == '7' || lPos == '*') {
                    row = findRow(keypad, lPos, 0);
                    lDis++;
                }
                
                else {
                    row = findRow(keypad, lPos, 1);
                }

                lDis += calcDistance(keypad, row, push);
                
                // 오른손이 갈 수 있는 최단거리 찾기
                if(rPos == '3' || rPos == '6' || rPos == '9' || rPos == '#') {
                    row = findRow(keypad, rPos, 2);
                    rDis++;
                }
                
                else {
                    row = findRow(keypad, rPos, 1);
                }

                rDis += calcDistance(keypad, row, push);

                // 왼손과 오른손 중 더 짧은 거리 찾기
                if(lDis < rDis) { lPos = push; answer += "L";  }
                else if (lDis > rDis) { rPos = push; answer += "R"; }
                else {
                    if(hand.equals("left")) { lPos = push; answer += "L";  }
                    else { rPos = push; answer += "R"; }
                }

            }
        } 
        return answer;
    }

    public static int findRow(char[][] keypad, char pos, int col) {
        int row = 0;
        for(int i = 0; i < keypad.length; i ++)
            if(keypad[i][col] == pos) { row = i; break; }
        
        return row;
    }

    public static int calcDistance(char[][] keypad, int row, char push) {
        int d = 0;
        
        if(keypad[row][1] == push) return d;

        for(int i = row + 1; i < keypad.length; i++) {
            if(keypad[i][1] == push) {
                d = i - row;
                return d;
            }
        }

        for(int i = row - 1; i >= 0; i--) {
            if(keypad[i][1] == push) {
                d = row - i;
                return d;
            }
        }

        return d;
    }
}