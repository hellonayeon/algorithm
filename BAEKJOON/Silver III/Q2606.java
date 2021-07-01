import java.io.*;

class Q2606 {

    private static int infection = 0; // 감염시킨 컴퓨터 수 (1번 컴퓨터는 제외)
    private static int[][] net; // 네트워크, 연결된 컴퓨터 정보, 인접행렬
    private static boolean[] check; // 감염 체크 여부

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int com = Integer.parseInt(br.readLine()) + 1; // 컴퓨터 수 (배열 요소 1부터 접근하기 위해)
        int pair = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수

        net = new int[com][com];
        check = new boolean[com]; // 바이러스 감염 여부를 확인한 컴퓨터 체크

        for(int i = 1; i <= pair; i++) {
            String[] input = br.readLine().split(" ");
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);

            net[row][col] = 1; // 서로 연결된 컴퓨터 표시
            net[col][row] = 1;
        }
        
        dfs(1);
        System.out.print(infection);
    }

    public static void dfs(int com) {
        check[com] = true;
        for(int i = 1; i < net.length; i++) {
            if(!check[i] && net[com][i] == 1) {
                infection++;
                dfs(i);
            }
        }
    }
}