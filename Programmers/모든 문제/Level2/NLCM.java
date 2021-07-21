import java.util.Arrays;

class NLCM {
    public int solution(int[] arr) {
        Arrays.sort(arr);

        int lcm = 0;
        int num = arr[arr.length-1];
        int x = 1;
        while(true) {
            lcm = num * x++;
            if(chkLCM(arr, lcm)) break;
        }

        return lcm;
    }

    public boolean chkLCM(int[] arr, int lcm) {
        for(int i = 0; i < arr.length - 1; i++) {
            if(lcm % arr[i] != 0) return false;
        }
        return true;
    }

}