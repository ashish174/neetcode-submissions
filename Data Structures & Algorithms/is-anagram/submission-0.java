class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!= t.length()) {
            return false;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();
        for(char ch : s.toCharArray()) {
            if(charCountMap.containsKey(ch)){
                charCountMap.put(ch, charCountMap.get(ch)+1);
            } else {
                charCountMap.put(ch, 1);
            }
        }
        for(char ch2 : t.toCharArray()) {
            if(charCountMap.containsKey(ch2)) {
                if(charCountMap.get(ch2) > 1) {
                    charCountMap.put(ch2, charCountMap.get(ch2)-1);
                } else {
                    charCountMap.remove(ch2);
                }
            } else {
                return false;
            }
        }
        return charCountMap.isEmpty() ? true : false;
    }
}
