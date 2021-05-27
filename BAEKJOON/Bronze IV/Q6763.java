import java.io.*;

class Q6763 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int limit = Integer.parseInt(br.readLine());
        int speed = Integer.parseInt(br.readLine());
        
        int diff = speed - limit;
        if (diff <= 0)
            System.out.println("Congratulations, you are within the speed limit!");
        else if (diff >=1 && diff <= 20)
            System.out.println("You are speeding and your fine is $100.");
        else if (diff >= 21 && diff <= 30)
            System.out.println("You are speeding and your fine is $270.");
        else
            System.out.println("You are speeding and your fine is $500.");
    }
}