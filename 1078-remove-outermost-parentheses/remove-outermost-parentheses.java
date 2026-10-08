class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if( c == '(' && st.empty()){
                st.push(c);
            }
            else if(c == '(' && !st.empty()){
                ans.append(c);
                st.push(c);
            }
            if( c == ')' && st.size() > 1){
                st.pop();
                ans.append(c);
            }
            else if(c == ')' && st.size() == 1){
                st.pop();
            }



        }
        return ans.toString();
        
    }
}