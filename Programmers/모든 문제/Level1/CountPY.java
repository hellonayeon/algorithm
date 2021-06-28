class CountPY {
    boolean solution(String s) {
        s = s.toLowerCase();
        
        return (countChar(s, 'p') == countChar(s, 'y'));
    }
    
    public long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }
}
