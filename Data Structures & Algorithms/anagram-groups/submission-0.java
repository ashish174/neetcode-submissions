class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramsList = new ArrayList<>();
        for(String str : strs) {
            if(anagramsList.size()==0) {
                anagramsList.add(new ArrayList<>(Arrays.asList(str)));
            } else {
                boolean isAnagramFound = false;
                for(List<String> anagrams : anagramsList) {
                    isAnagramFound = isAnagram(anagrams.get(0), str);
                    if(isAnagramFound){
                        anagrams.add(str);
                        break;
                    } 
                }
                if(!isAnagramFound){
                    anagramsList.add(new ArrayList<>(Arrays.asList(str)));
                }
            }
        }
        return anagramsList;
    }

    boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) {
            return false;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();
        for(char ch1 : s.toCharArray()){
            if(!charCountMap.containsKey(ch1)){
                charCountMap.put(ch1, 1);
            } else {
                charCountMap.put(ch1, charCountMap.get(ch1)+1);
            }
        }

        for(char ch2 : t.toCharArray()) {
            if(!charCountMap.containsKey(ch2)) {
                return false;
            } else {
                if(charCountMap.get(ch2) > 1) {
                    charCountMap.put(ch2, charCountMap.get(ch2)-1);
                } else {
                    charCountMap.remove(ch2);
                }
            }
        }
        return true;
    }
}
