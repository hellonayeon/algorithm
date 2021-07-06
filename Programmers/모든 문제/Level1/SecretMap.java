class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] bin1 = dec_to_bin(n, arr1);
        String[] bin2 = dec_to_bin(n, arr2);
        
        return decode(n, bin1, bin2);
    }
    
    public String[] dec_to_bin(int n, int[] arr) {
        String[] bins = new String[n];
        
        for(int idx = 0; idx < n; idx++) {
            int dec = arr[idx];
            
            String str = "";
            while(dec > 0) {
                str = (dec % 2) + str;
                dec /= 2;
            }
            
            // 이진수 자릿수 맞추기
            if(str.length() < n) {
                int range = n - str.length();
                for(int i = 0; i < range; i++)
                    str = "0" + str;    
            }
            
            bins[idx] = str;
        }
        
        return bins;
    }
    
    public String[] decode(int n, String[] bin1, String[] bin2) {
        String[] cipher_txt = new String[n];
        
        for(int idx = 0; idx < n; idx++) {
            String txt = "";
            
            for(int i = 0; i < n; i++) {
                if(bin1[idx].charAt(i) == '0' && bin2[idx].charAt(i) == '0') txt += " ";
                else txt += "#";
            }
            
            cipher_txt[idx] = txt;
        }
        return cipher_txt;
    }
}