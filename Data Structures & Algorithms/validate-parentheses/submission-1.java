class Solution {
    public boolean isValid(String s) {
        Stack<Character> braceMatcher = new Stack<>();
        for(char ch : s.toCharArray()){
            switch(ch) {
                case '[':
                case '{':
                case '(':
                    braceMatcher.push(ch);
                    break;
                case ']':
                    if(braceMatcher.isEmpty() || braceMatcher.pop()!='['){
                        return false;
                    };
                    break;  
                case '}':
                    if(braceMatcher.isEmpty() || braceMatcher.pop()!='{'){
                        return false;
                    };
                    break;
                case ')':
                    if(braceMatcher.isEmpty() || braceMatcher.pop()!='('){
                        return false;
                    };
                    break;
                default:
                    return false;
            }
        }
        return braceMatcher.isEmpty(); 
    }
}
