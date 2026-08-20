class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for(char ch : s.toCharArray()){
            if((ch >= 65 && ch <=90) || (ch >=97 && ch <=122) || (ch >=48 && ch <=57) ) {
                builder.append(ch);
            }
        }
        String str = builder.toString();
        String reverseStr = builder.reverse().toString();
        return str.equalsIgnoreCase(reverseStr);
    }
}
