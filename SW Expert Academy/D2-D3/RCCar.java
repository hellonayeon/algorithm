import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.io.FileInputStream;

class RCCar {

    static int speed;
    static int meter;

    public static void main(String args[]) throws IOException {
        System.setIn(new FileInputStream("res/RCCar_input.txt"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            speed = 0; meter = 0;
            for(int i = 0; i < N; i++) {
                String[] Input = br.readLine().split(" ");

                calcMeter(Input);    
            }

            System.out.println("#" + tc + " " + meter);
        }
    }

    public static void calcMeter(String[] Input) {
        int command, acc = 0;

        if(Input.length == 1) {
            command = Integer.parseInt(Input[0]);
        }
        else {
            command = Integer.parseInt(Input[0]);
            acc = Integer.parseInt(Input[1]);
        }

        if(command == 1) {
            speed += acc;
        }
        else if(command == 2) {
            if(speed - acc < 0) speed = 0;
            else speed -= acc;
        }
        
        meter += speed;
    }
}