import java.io.*;

class Q5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] burger = new int[3];
        int[] drink = new int[3];
        
        for(int i=0; i<3; i++)
            burger[i] = Integer.parseInt(br.readLine());
        
        for(int i=0; i<2; i++)
            drink[i] = Integer.parseInt(br.readLine());
        
        
        int cb = burger[0]; // cheaper burger
        for(int i=1; i<burger.length; i++) {
            if(burger[i] < cb) {
                cb = burger[i];
            }
        }    
        
        int cd = (drink[0] < drink[1]) ? drink[0] : drink[1]; // cheaper drink
        
        int price = cb + cd - 50;
        
        System.out.println(price);
        
    }
}