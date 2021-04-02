import java.util.Scanner;

class Q1550 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hex = sc.next();
        
        sc.close();

        System.out.println(Integer.parseInt(hex, 16));
    }
}
