import java.util.HashMap;

class PhoneNumber {
    public boolean solution(String[] phone_book) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < phone_book.length; i++)
            map.put(phone_book[i], phone_book[i].length());
        
        for(String prefix : map.keySet()) {
            
            int pre_len = map.get(prefix);
            
            for(String phone_number : map.keySet()) {
                if(phone_number == prefix) continue;
                
                int num_len = map.get(phone_number);
                if(num_len > pre_len && phone_number.substring(0, pre_len).equals(prefix))
                    return false;
                    
            }
        }
        return true;
    }
}
