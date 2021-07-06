import java.util.Scanner;

class StarSquare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
            
        System.out.println(sb.toString());
    }    
}
