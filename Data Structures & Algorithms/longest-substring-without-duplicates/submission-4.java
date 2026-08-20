class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charPosition = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        for(int i=0; i<s.length(); i++){
            if(charPosition.containsKey(s.charAt(i)) 
            && start <= charPosition.get(s.charAt(i) )){
                int repeatedCharPosition = charPosition.get(s.charAt(i));
                start = repeatedCharPosition + 1;
            }
            charPosition.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i-start+1);
        }
        return maxLength;
        
    }
}
