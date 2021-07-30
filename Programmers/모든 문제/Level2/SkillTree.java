import java.util.HashSet;

class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int ans = skill_trees.length;
        
        HashSet<Character> set = new HashSet<>();
        for(char c : skill.toCharArray()) set.add(c);
        
        for(String s : skill_trees) {
            int next = 0;
            
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                
                if(set.contains(c) && c != skill.charAt(next)) {
                    ans--;
                    break;
                }
                
                if(set.contains(c) && c == skill.charAt(next)) next++;
            }
        }
        
        return ans;
    }
}
