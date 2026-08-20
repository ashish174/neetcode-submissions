class Solution {
    public int characterReplacement(String s, int k) {
                int maxLength = 0;
        int l = 0;
        int maxFrequency = 0;
        Map<Character, Integer> charCountInWindowMap = new HashMap<>();
        for(int r=0; r < s.length(); r++) {
            char ch = s.charAt(r);
            charCountInWindowMap.put(ch, charCountInWindowMap.getOrDefault(ch, 0)+1 );
            maxFrequency = Math.max(maxFrequency, charCountInWindowMap.get(ch));
            //windowSize = r-l+1;
            //IF windowSize - maxFrequency > k, then we have to keep shifting left pointer
            while((r-l+1) - maxFrequency > k) {
                charCountInWindowMap.put(s.charAt(l), charCountInWindowMap.get(s.charAt(l))-1);
                l++;
            }
            maxLength = Math.max(maxLength, r-l+1);
        }
        return maxLength;
    }
}
