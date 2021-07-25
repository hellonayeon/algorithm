import java.util.Arrays;

class MinMax {
  public String solution(String s) {
      String[] nums = s.split(" ");
      int[] arr = new int[nums.length];

      for (int i = 0; i < nums.length; i++) {
          arr[i] = Integer.parseInt(nums[i]);
      }
      Arrays.sort(arr);

      return arr[0] + " " + arr[arr.length - 1];
  }
}